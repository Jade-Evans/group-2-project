//App imports
package com.cfgmasters.group2project.services;
import com.cfgmasters.CoffeeApp.model.entity.CoffeeProduct;
import com.cfgmasters.CoffeeApp.repository.CoffeeProductRepository;
import com.cfgmasters.CoffeeApp.services.CoffeeProductService;
//Enum imports:
import static com.cfgmasters.CoffeeApp.model.entity.BlendType.BEAN;
import static com.cfgmasters.CoffeeApp.model.entity.BlendType.GROUND;
//Java imports
import java.util.ArrayList;
import java.util.List;
//Mockito Imports
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
//JUnit imports:
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//Spring framework imports:
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



@ExtendWith(MockitoExtension.class)
public class CoffeeProductServiceTests {

    //Mocks:
    //creates mock reference to DB - negates @Autowired real bean injection
    @Mock
    private CoffeeProductRepository coffeeProductRepository;
    // Injects mock CoffeeProductController bean into this test
    @InjectMocks
    private CoffeeProductService coffeeProductService;

    // ARRANGE
    // Set up the objects and data needed for the test
    // ============================================================
    //1. Create new CoffeeProduct objects using builder syntax to both declare object and set its attribute values.
    //NOTE TO SELF: These are actual objects, but used in the context of testing.
    //NOTE TO SELF: Entities cannot be beans, as there's no single source of truth like controller/repository.
    //Populate product1 with field attributes using builder syntax:
    CoffeeProduct product1 = CoffeeProduct.builder()
            .id(1L)
            .name("HouseBlend1")
            .blendType(BEAN)
            .weightInGrams(250)
            .strength(1)
            .decaf(true)
            .price(10.50)
            .orderTotal(0)
            .stockTotal(50)
            .build();
    CoffeeProduct product2 = CoffeeProduct.builder()
            .id(2L)
            .name("RoyalBlend2")
            .blendType(BEAN)
            .weightInGrams(500)
            .strength(3)
            .decaf(false)
            .price(10.50)
            .orderTotal(0)
            .stockTotal(50)
            .build();

    CoffeeProduct product3 = CoffeeProduct.builder()
            .id(3L)
            .name("DarkRoast3")
            .blendType(BEAN)
            .weightInGrams(1998)
            .strength(5)
            .decaf(false)
            .price(10.50)
            .orderTotal(0)
            .stockTotal(50)
            .build();

    CoffeeProduct product4 = CoffeeProduct.builder()
            .id(4L)
            .name("MildBlend4")
            .blendType(BEAN)
            .weightInGrams(500)
            .strength(1)
            .decaf(true)
            .price(10.50)
            .orderTotal(0)
            .stockTotal(50)
            .build();

    // Create the input list that will be passed into the method
    List<CoffeeProduct> listOfProducts;

    @BeforeEach
    void setup() {
        listOfProducts = new ArrayList<>();
        listOfProducts.add(product1);
        listOfProducts.add(product2);
        listOfProducts.add(product3);
        listOfProducts.add(product4);
    }


    //---------------------------------------------------//
    //VALID INPUT TESTING:
//---------------------------------------------------//
    @Test
    //Happy Path = "BEAN" → return list of coffee bean products
    void findByBlendTypeAndStrength_ValidTypeUpperCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        //ARRANGE (N.B. This isn't what's being tested
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        //ACT // (call method findByBlendTypeAndStrength());
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("BEAN", strength);
        //ASSERT (this match is what is tested):
        assertEquals(expected, actual);
    }
    @Test
        //LowerCase Path = "bean" → returns list same as above (handled by toUpperCase())
    void findByBlendTypeAndStrength_ValidTypeAllLowerCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        //ARRANGE (N.B. This isn't what's being tested
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        //ACT // (call method findByBlendTypeAndStrength());
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("bean", strength);
        //ASSERT (this match is what is tested):
        assertEquals(expected, actual);
    }
    @Test
        //MixedCase Path = ""BEan" → returns list same as above (handled by toUpperCase())
    void findByBlendTypeAndStrength_ValidTypeMixedCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        //ARRANGE (N.B. This isn't what's being tested
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        //ACT // (call method findByBlendTypeAndStrength());
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("BEan", strength);
        //ASSERT (this match is what is tested):
        assertEquals(expected, actual);
    }
    @Test
        //White space Path = "  BEAN  "→ returns list same as above (handled by .trim())
    void findByBlendTypeAndStrength_ValidTypeWhiteSpace_ReturnsProductsMatchingBlendTypeAndStrength() {
        //ARRANGE (N.B. This isn't what's being tested
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        //ACT // (call method findByBlendTypeAndStrength());
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("  BEAN  ", strength);
        //ASSERT (this match is what is tested):
        assertEquals(expected, actual);
    }
    //---------------------------------------------------//
    //INVALID INPUT TESTING:
    //---------------------------------------------------//
    @Test
    //Null Path = null → throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search - please enter a valid strength value.");
    void findByBlendTypeAndStrength_NullTypeInput_ThrowsBadRequest() {
        int strength = 1;
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class,()->
                        coffeeProductService.findByBlendTypeAndStrength(null, strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
        //Blank path= " " → throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search - please enter a valid strength value.");
    void findByBlendTypeAndStrength_BlankTypeInputWithSpaces_ThrowsBadRequest() {
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        int strength = 1;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class,()->
                        coffeeProductService.findByBlendTypeAndStrength(" ", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
        //Blank path(no characters) "" → throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search - please enter a valid strength value.");
    void findByBlendTypeAndStrength_BlankTypeInputNoSpaces_ThrowsBadRequest() {
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        int strength = 1;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class,()->
                        coffeeProductService.findByBlendTypeAndStrength("", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
        //Invalid input = "BANANA" → throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search - please enter a valid type value.");
    void findByBlendTypeAndStrength_InvalidTypeInput_ThrowsBadRequest() {
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        int strength = 1;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class,()->
                        coffeeProductService.findByBlendTypeAndStrength("BANANA", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    @Test
        //Valid Value in Enum but not found (in Database) = "GROUND" -> doesn't throw error, returns empty arraylist.
    void findByBlendTypeAndStrength_ValidTypeInputNotFoundInDB_ReturnsEmptyList() {
            //nothing referencing repo is required as this error is caught beforehand
            //ACT:
            int strength = 1;
            ResponseStatusException exception =
                    assertThrows(ResponseStatusException.class,()->
                            coffeeProductService.findByBlendTypeAndStrength("GROUND", strength)
                    );
            //ASSERT:
            assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }
}
