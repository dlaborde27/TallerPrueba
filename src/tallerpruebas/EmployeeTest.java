package tallerpruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class EmployeeTest {
	Employee worker = new Employee(500, "USD", 0.1f, EmployeeType.Worker);
    Employee supervisor = new Employee(800, "USD", 0.2f, EmployeeType.Supervisor);
    Employee manager = new Employee(1500, "USD", 0.3f, EmployeeType.Manager);

    Employee worker2 = new Employee(500, "EUR", 0.1f, EmployeeType.Worker);



    @Test
    @DisplayName("Salario segun el tipo de trabajador 'USD' y mes impar")
    void salarioSegunElTipoDeTrabajadorUsd_MesImpar() {
        assertAll("SALARIO USD",
                () -> assertEquals(564.3, worker.cs(1), 1),
                () ->assertEquals(864.4, supervisor.cs(1), 1),
                () ->assertEquals(1564.5, manager.cs(1), 1));
    }
    
    @Test
    @DisplayName("Salario segun el tipo de trabajador 'USD' y mes par")
    void salarioSegunElTipoDeTrabajadorUsd_MesPar() {
        assertAll("SALARIO USD",
                () -> assertEquals(500, worker.cs(2), 1),
                () ->assertEquals(800, supervisor.cs(2), 1),
                () ->assertEquals(1500, manager.cs(2), 1));
    }

    @Test
    @DisplayName("Salario segun tipo de trabajador 'not USD' mes impar")
    void salarioSegunTipoDeTrabajadorNotUsd_MesImpar() {
    	assertEquals(539.3, worker2.cs(1));
    }
    

    @Test
    @DisplayName("Bono segun tipo de trabajador 'USD'")
    void bonoSegunTipoDeTrabajadorUsd() {
        assertAll("Bono USD",
                () -> assertEquals(386.0, worker.CalculateYearBonus(), 1),
                () ->assertEquals(993.0, supervisor.CalculateYearBonus(), 1),
                () ->assertEquals(1886.0, manager.CalculateYearBonus(), 1));
    }

    @Test
    @DisplayName("Bono segun tipo de trabajador 'not USD'")
    void bonoSegunTipoDeTrabajadorNotUsd() {
      assertEquals(386.0, worker2.CalculateYearBonus());
    }
                
}

