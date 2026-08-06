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
    // ARRANGE: Set up mock data testing
    // ============================================================
    @Mock
    private CoffeeProductRepository coffeeProductRepository;

    @InjectMocks
    private CoffeeProductService coffeeProductService;

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
        listOfProducts = List.of(product1, product2, product3, product4);
    }
    //---------------------------------------------------//
    //VALID INPUT TESTING: findByBlendTypeAndStrength()
    //---------------------------------------------------//
    @Test
    void findByBlendTypeAndStrength_ValidTypeUpperCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("BEAN", strength);
        assertEquals(expected, actual);
    }

    @Test
    void findByBlendTypeAndStrength_ValidTypeAllLowerCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("bean", strength);
        assertEquals(expected, actual);
    }

    @Test
    void findByBlendTypeAndStrength_ValidTypeMixedCase_ReturnsProductsMatchingBlendTypeAndStrength() {
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("BEan", strength);
        assertEquals(expected, actual);
    }

    @Test
        //White space Path = "  BEAN  "→ returns list same as above (handled by .trim())
    void findByBlendTypeAndStrength_ValidTypeWhiteSpace_ReturnsProductsMatchingBlendTypeAndStrength() {
        int strength = 1;
        List<CoffeeProduct> expected = List.of(product1, product4);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("  BEAN  ", strength);
        assertEquals(expected, actual);
    }

    //---------------------------------------------------//
    //INVALID INPUT TESTING: findByBlendTypeAndStrength()
    //---------------------------------------------------//
    @Test
    //Null Path = null → throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search - please enter a valid strength value.");
    void findByBlendTypeAndStrength_NullTypeInput_ThrowsBadRequest() {
        int strength = 1;
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () ->
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
                assertThrows(ResponseStatusException.class, () ->
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
                assertThrows(ResponseStatusException.class, () ->
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
                assertThrows(ResponseStatusException.class, () ->
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
                assertThrows(ResponseStatusException.class, () ->
                        coffeeProductService.findByBlendTypeAndStrength("GROUND", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    //---------------------------------------------------//
    //INVALID STRENGTH INPUT TESTING: findByBlendTypeAndStrength()
    //---------------------------------------------------//
    @Test
    //Valid Strength value but not found (in Database) = 4 -> doesn't throw error, returns empty arraylist.
    void findByBlendTypeAndStrength_ValidStrengthInputNotFoundInDB_ReturnsEmptyList() {
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        int strength = 4;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () ->
                        coffeeProductService.findByBlendTypeAndStrength("BEAN", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
    }

    @Test
        //Valid Strength value but not found (in Database) = 4 -> doesn't throw error, returns empty arraylist.
    void findByBlendTypeAndStrength_StrengthInputGreaterThan5_ThrowsBadRequestException() {
        //nothing referencing repo is required as this error is caught beforehand
        //ACT:
        int strength = 7;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () ->
                        coffeeProductService.findByBlendTypeAndStrength("BEAN", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    void findByBlendTypeAndStrength_StrengthInputIsNegative_ThrowsBadRequestException() {
        int strength = -5;
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () ->
                        coffeeProductService.findByBlendTypeAndStrength("BEAN", strength)
                );
        //ASSERT:
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    void findByBlendTypeAndStrength_StrengthInputIsNull_ThrowsBadRequestException() {
        //ACT:
        // ARRANGE
        Integer strength = null;
        // ACT
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () ->
                        coffeeProductService.findByBlendTypeAndStrength("BEAN", strength)
                );
        // ASSERT
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }
    //EDGE CASES:

    //Strength is 5 (Strength is 1 is covered in earlier tests):
    @Test
    void findByBlendTypeAndStrength_StrengthValueIs5_ReturnsProductsMatchingBlendTypeAndStrength() {
        //ARRANGE (N.B. This isn't what's being tested
        int strength = 5;
        List<CoffeeProduct> expected = List.of(product3);
        when(coffeeProductRepository.findByBlendTypeAndStrength(BEAN, strength)).thenReturn(expected);
        //ACT // (call method findByBlendTypeAndStrength());
        List<CoffeeProduct> actual = coffeeProductService.findByBlendTypeAndStrength("BEAN", strength);
        
        assertEquals(expected, actual);
    }

}

