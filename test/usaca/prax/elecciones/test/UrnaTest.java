package usaca.prax.elecciones.test;

import usaca.prax.elecciones.mundo.Urna;

import junit.framework.TestCase;

public class UrnaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Urna urna;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Urna vacía
     *
     */
    private void setupEscenario1( )
    {
        urna = new Urna( );
        urna.inicializar( );
    }

    /**
     * Construye una urna, donde cada candidato tiene un voto de cada tipo
     */
    private void setupEscenario2( )
    {
        urna = new Urna( );
        urna.inicializar( );

        urna.ingresarVotoTelevision( urna.darCandidato1() );
        urna.ingresarVotoTelevision( urna.darCandidato2() );
        urna.ingresarVotoTelevision( urna.darCandidato3() );

        urna.ingresarVotoRadio( urna.darCandidato1() );
        urna.ingresarVotoRadio( urna.darCandidato2() );
        urna.ingresarVotoRadio( urna.darCandidato3() );

        urna.ingresarVotoInternet( urna.darCandidato1() );
        urna.ingresarVotoInternet( urna.darCandidato2() );
        urna.ingresarVotoInternet( urna.darCandidato3() );
    }

    /**
     * Prueba 1 - Inicialización de los candidatos
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "El candidato 1 debe estar inicializado", urna.darCandidato1( ) );
        assertNotNull( "El candidato 2 debe estar inicializado", urna.darCandidato2( ) );
        assertNotNull( "El candidato 3 debe estar inicializado", urna.darCandidato3( ) );
    }

    /**
     * Prueba 2 - Ingresar voto influenciado por la televisión a los candidatos.
     */
    public void testIngresarVotoTelevision( )
    {
        setupEscenario1( );

        urna.ingresarVotoTelevision( urna.darCandidato1() );
        urna.ingresarVotoTelevision( urna.darCandidato2() );
        urna.ingresarVotoTelevision( urna.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato1( ).getCostoCampanha( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato2( ).getCostoCampanha( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato3( ).getCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 3 - Ingresar voto influenciado por la radio a los candidatos.
     */
    public void testIngresarVotoRadio( )
    {
        setupEscenario1( );

        urna.ingresarVotoRadio( urna.darCandidato1() );
        urna.ingresarVotoRadio( urna.darCandidato2() );
        urna.ingresarVotoRadio( urna.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato1( ).getCostoCampanha( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato2( ).getCostoCampanha( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato3( ).getCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 4 - Ingresar voto influenciado por Internet a los candidatos.
     */
    public void testIngresarVotoInternet( )
    {
        setupEscenario1( );

        urna.ingresarVotoInternet( urna.darCandidato1() );
        urna.ingresarVotoInternet( urna.darCandidato2() );
        urna.ingresarVotoInternet( urna.darCandidato3() );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato1( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato1( ).getCostoCampanha( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato2( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato2( ).getCostoCampanha( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urna.darCandidato3( ).getVotos( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato3( ).getCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 11 - Calcular el total de votos que posee la urna
     */
    public void testCalcularTotalVotos( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el total de votos correctamente", urna.calcularTotalVotos( ) == 9 );

    }

    /**
     * Prueba 12 - Calcular el costo promedio de campaña de los candidatos
     */
    public void testCalcularCostoPromedioCampanha( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el costo promedio de campaña correctamente", urna.calcularCostoPromedioCampanha( ) == 1600 );
    }

    /**
     * Prueba 13 - Calcular el porcentaje de los votos obtenidos por los candidatos.
     */
    public void testCalcularPorcentajeVotosCandidato1( )
    {
        setupEscenario2( );

        double porcentaje = ( double )3 / ( double )9 * ( double )100;

        assertTrue( "No calcula el costo promedio de campaña correctamente", urna.calcularPorcentajeVotos( urna.darCandidato1() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urna.calcularPorcentajeVotos( urna.darCandidato2() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urna.calcularPorcentajeVotos( urna.darCandidato3() ) == porcentaje );
    }

    /**
     * Prueba 16 - Vaciar la urna de votación
     */
    public void testVaciarUrna( )
    {
        setupEscenario2( );

        urna.vaciarUrna( );

        assertTrue( "No inicializa el número de votos a 0 del candidato 1", urna.darCandidato1( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 1", urna.darCandidato1( ).getCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 2", urna.darCandidato2( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 2", urna.darCandidato2( ).getCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 3", urna.darCandidato3( ).getVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 3", urna.darCandidato3( ).getCostoCampanha( ) == 0 );

    }
}
