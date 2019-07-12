package edu.usc.elecciones.test;

import edu.usc.elecciones.mundo.Urn;

import junit.framework.TestCase;

public class UrnTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Urn urn;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Urna vacía
     *
     */
    private void setupEscenario1( )
    {
        urn = new Urn( );
    }

    /**
     * Construye una urna, donde cada candidato tiene un voto de cada tipo
     */
    private void setupEscenario2( )
    {
        urn = new Urn( );

        urn.ingresarVotoTelevision( urn.darCandidato1() );
        urn.ingresarVotoTelevision( urn.darCandidato2() );
        urn.ingresarVotoTelevision( urn.darCandidato3() );

        urn.ingresarVotoRadio( urn.darCandidato1() );
        urn.ingresarVotoRadio( urn.darCandidato2() );
        urn.ingresarVotoRadio( urn.darCandidato3() );

        urn.ingresarVotoInternet( urn.darCandidato1() );
        urn.ingresarVotoInternet( urn.darCandidato2() );
        urn.ingresarVotoInternet( urn.darCandidato3() );
    }

    /**
     * Prueba 1 - Inicialización de los candidatos
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "El candidato 1 debe estar inicializado", urn.darCandidato1( ) );
        assertNotNull( "El candidato 2 debe estar inicializado", urn.darCandidato2( ) );
        assertNotNull( "El candidato 3 debe estar inicializado", urn.darCandidato3( ) );
    }

    /**
     * Prueba 2 - Ingresar voto influenciado por la televisión a los candidatos.
     */
    public void testIngresarVotoTelevision( )
    {
        setupEscenario1( );

        urn.ingresarVotoTelevision( urn.darCandidato1() );
        urn.ingresarVotoTelevision( urn.darCandidato2() );
        urn.ingresarVotoTelevision( urn.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.darCandidato1( ).getCostoCampanha( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.darCandidato2( ).getCostoCampanha( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.darCandidato3( ).getCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 3 - Ingresar voto influenciado por la radio a los candidatos.
     */
    public void testIngresarVotoRadio( )
    {
        setupEscenario1( );

        urn.ingresarVotoRadio( urn.darCandidato1() );
        urn.ingresarVotoRadio( urn.darCandidato2() );
        urn.ingresarVotoRadio( urn.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.darCandidato1( ).getCostoCampanha( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.darCandidato2( ).getCostoCampanha( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.darCandidato3( ).getCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 4 - Ingresar voto influenciado por Internet a los candidatos.
     */
    public void testIngresarVotoInternet( )
    {
        setupEscenario1( );

        urn.ingresarVotoInternet( urn.darCandidato1() );
        urn.ingresarVotoInternet( urn.darCandidato2() );
        urn.ingresarVotoInternet( urn.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.darCandidato1( ).getCostoCampanha( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.darCandidato2( ).getCostoCampanha( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.darCandidato3( ).getCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 11 - Calcular el total de votos que posee la urna
     */
    public void testCalcularTotalVotos( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el total de votos correctamente", urn.calcularTotalVotos( ) == 9 );

    }

    /**
     * Prueba 12 - Calcular el costo promedio de campaña de los candidatos
     */
    public void testCalcularCostoPromedioCampanha( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calcularCostoPromedioCampanha( ) == 1600 );
    }

    /**
     * Prueba 13 - Calcular el porcentaje de los votos obtenidos por los candidatos.
     */
    public void testCalcularPorcentajeVotosCandidato1( )
    {
        setupEscenario2( );

        double porcentaje = ( double )3 / ( double )9 * ( double )100;

        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calcularPorcentajeVotos( urn.darCandidato1() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calcularPorcentajeVotos( urn.darCandidato2() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calcularPorcentajeVotos( urn.darCandidato3() ) == porcentaje );
    }

    /**
     * Prueba 16 - Vaciar la urna de votación
     */
    public void testVaciarUrna( )
    {
        setupEscenario2( );

        urn.vaciarUrna( );

        assertTrue( "No inicializa el número de votos a 0 del candidato 1", urn.darCandidato1( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 1", urn.darCandidato1( ).getCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 2", urn.darCandidato2( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 2", urn.darCandidato2( ).getCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 3", urn.darCandidato3( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 3", urn.darCandidato3( ).getCostoCampanha( ) == 0 );

    }
}
