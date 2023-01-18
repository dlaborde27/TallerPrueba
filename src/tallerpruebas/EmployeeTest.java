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
    Employee workerEuro = new Employee(500, "EUR", 0.1f, EmployeeType.Worker);

    @Test
    void salarioSegunElTipoDeTrabajadorUsd_MesImpar() {
        assertEquals(564.30, worker.cs(1), 2);
        assertEquals(864.40, supervisor.cs(1), 2);
        assertEquals(1564.50, manager.cs(1), 2);
    }
    
    @Test
    void salarioSegunElTipoDeTrabajadorUsd_MesPar() {
        assertEquals(500, worker.cs(2), 2);
        assertEquals(800, supervisor.cs(2), 2);
        assertEquals(1500, manager.cs(2), 2);
    }

    @Test
    void salarioSegunTipoDeTrabajadorNotUsd_MesImpar() {
    	assertEquals(539.33, workerEuro.cs(1), 2);
    }
    

    @Test
    void bonoSegunTipoDeTrabajadorUsd() {
        assertEquals(386.00, worker.CalculateYearBonus(), 2);
        assertEquals(993.00, supervisor.CalculateYearBonus(), 2);
        assertEquals(1886.00, manager.CalculateYearBonus(), 2);
    }

    @Test
    void bonoSegunTipoDeTrabajadorNotUsd() {
      assertEquals(386.00, workerEuro.CalculateYearBonus(), 2);
    }


    // Asunciones: 
    // - El salario debe ser un positivo real
    // - El tipo de empleado no debe ser nulo
    // - La divisa debe estar en mayuscula
}

