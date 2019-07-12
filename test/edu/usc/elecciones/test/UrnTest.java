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

        urn.addVoteTelevision( urn.getFrank() );
        urn.addVoteTelevision( urn.getClaire() );
        urn.addVoteTelevision( urn.getBarack() );

        urn.addVoteRadio( urn.getFrank() );
        urn.addVoteRadio( urn.getClaire() );
        urn.addVoteRadio( urn.getBarack() );

        urn.addVoteInternet( urn.getFrank() );
        urn.addVoteInternet( urn.getClaire() );
        urn.addVoteInternet( urn.getBarack() );
    }

    /**
     * Prueba 1 - Inicialización de los candidatos
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "El candidato 1 debe estar inicializado", urn.getFrank( ) );
        assertNotNull( "El candidato 2 debe estar inicializado", urn.getClaire( ) );
        assertNotNull( "El candidato 3 debe estar inicializado", urn.getBarack( ) );
    }

    /**
     * Prueba 2 - Ingresar voto influenciado por la televisión a los candidatos.
     */
    public void testIngresarVotoTelevision( )
    {
        setupEscenario1( );

        urn.addVoteTelevision( urn.getFrank() );
        urn.addVoteTelevision( urn.getClaire() );
        urn.addVoteTelevision( urn.getBarack() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getFrank( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.getFrank( ).getCostCampaign( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getClaire( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.getClaire( ).getCostCampaign( ) == 1000 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getBarack( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urn.getBarack( ).getCostCampaign( ) == 1000 );
    }

    /**
     * Prueba 3 - Ingresar voto influenciado por la radio a los candidatos.
     */
    public void testIngresarVotoRadio( )
    {
        setupEscenario1( );

        urn.addVoteRadio( urn.getFrank() );
        urn.addVoteRadio( urn.getClaire() );
        urn.addVoteRadio( urn.getBarack() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getFrank( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.getFrank( ).getCostCampaign( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getClaire( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.getClaire( ).getCostCampaign( ) == 500 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getBarack( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 500", urn.getBarack( ).getCostCampaign( ) == 500 );
    }

    /**
     * Prueba 4 - Ingresar voto influenciado por Internet a los candidatos.
     */
    public void testIngresarVotoInternet( )
    {
        setupEscenario1( );

        urn.addVoteInternet( urn.getFrank() );
        urn.addVoteInternet( urn.getClaire() );
        urn.addVoteInternet( urn.getBarack() );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getFrank( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.getFrank( ).getCostCampaign( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getClaire( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.getClaire( ).getCostCampaign( ) == 100 );

        assertTrue( "Debería aumentar el número de votos en 1", urn.getBarack( ).getVotes( ) == 1 );
        assertTrue( "Debería aumentar el costo de campaña en 100", urn.getBarack( ).getCostCampaign( ) == 100 );
    }

    /**
     * Prueba 11 - Calcular el total de votos que posee la urna
     */
    public void testCalcularTotalVotos( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el total de votos correctamente", urn.calculateTotalVotes( ) == 9 );

    }

    /**
     * Prueba 12 - Calcular el costo promedio de campaña de los candidatos
     */
    public void testCalcularCostoPromedioCampanha( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calculateAverageCampaignCost( ) == 1600 );
    }

    /**
     * Prueba 13 - Calcular el porcentaje de los votos obtenidos por los candidatos.
     */
    public void testCalcularPorcentajeVotosCandidato1( )
    {
        setupEscenario2( );

        double porcentaje = ( double )3 / ( double )9 * ( double )100;

        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calculatePercentageVotes( urn.getFrank() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calculatePercentageVotes( urn.getClaire() ) == porcentaje );
        assertTrue( "No calcula el costo promedio de campaña correctamente", urn.calculatePercentageVotes( urn.getBarack() ) == porcentaje );
    }

    /**
     * Prueba 16 - Vaciar la urna de votación
     */
    public void testVaciarUrna( )
    {
        setupEscenario2( );

        urn.clearUrn( );

        assertTrue( "No inicializa el número de votos a 0 del candidato 1", urn.getFrank( ).getVotes( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 1", urn.getFrank( ).getCostCampaign( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 2", urn.getClaire( ).getVotes( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 2", urn.getClaire( ).getCostCampaign( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 3", urn.getBarack( ).getVotes( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 3", urn.getBarack( ).getCostCampaign( ) == 0 );

    }
}
