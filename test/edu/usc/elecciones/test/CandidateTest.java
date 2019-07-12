package edu.usc.elecciones.test;

import edu.usc.elecciones.mundo.Candidate;
import junit.framework.TestCase;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Candidato estén correctamente implementados
 */
public class CandidateTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Candidate candidate;

    // -----------------------------------------------------------------
    // Métodos
    // -------------------------

    /**
     * Construye un nuevo Candidato
     */
    private void setupEscenario1( )
    {
        candidate = new Candidate( "Felipe", "Pitti", "Independiente", 27 );
    }

    /**
     * Prueba 1 - Inicializar los datos del candidato correctamente
     */
    public void testInicializar( )
    {
        setupEscenario1( );

        assertEquals( "No se crea con el nombre dado por parámetro", "Felipe", candidate.getName( ) );
        assertEquals( "No se crea con el apellido dado por parámetro", "Pitti", candidate.getLastName( ) );
        assertEquals( "No se crea con el partido político dado por parámetro", "Independiente", candidate.getPoliticalParty( ) );
        assertEquals( "No se crea con la edad dada por parámetro", 27, candidate.getAge( ) );
        assertEquals( "No se crea con el costo de campaña en 0", 0.0, candidate.getCostCampaign( ) );
        assertEquals( "No se crea con el número de votos en 0", 0, candidate.getVotes( ) );
    }

    /**
     * Prueba 2 - Agregar un voto al candidato influenciado por la televisión correctamente
     */
    public void testAgregarVotoTelevision( )
    {
        setupEscenario1( );

        candidate.addVoteTelevision( );
        assertEquals( "No aumenta el número de votos en 1", 1, candidate.getVotes( ) );
        assertEquals( "No aumenta el costo de campaña en 1000", 1000.0, candidate.getCostCampaign( ) );
    }

    /**
     * Prueba 3 - Agregar un voto al candidato influenciado por la radio correctamente
     */
    public void testAgregarVotoRadio( )
    {
        setupEscenario1( );

        candidate.addVoteRadio( );
        assertEquals( "No aumenta el número de votos en 1", 1, candidate.getVotes( ) );
        assertEquals( "No aumenta el costo de campaña en 500", 500.0, candidate.getCostCampaign( ) );
    }

    /**
     * Prueba 4 - Agregar un voto al candidato influenciado por Internet correctamente
     */
    public void testAgregarVotoInternet( )
    {
        setupEscenario1( );

        candidate.addVoteInternet( );
        assertEquals( "No aumenta el número de votos en 1", 1, candidate.getVotes( ) );
        assertEquals( "No aumenta el costo de campaña en 100", 100.0, candidate.getCostCampaign( ) );
    }

    /**
     * Prueba 5 - Reiniciar los votos del candidato correctamente
     */
    public void testReiniciarConteoVotos( )
    {
        setupEscenario1( );

        candidate.addVoteTelevision( );
        candidate.addVoteRadio( );
        candidate.addVoteInternet( );
        candidate.restartVoteCount( );

        assertEquals( "No inicializa el número de votos a 0", 0, candidate.getVotes( ) );
    }

    /**
     * Prueba 6 - Reiniciar el costo de campaña del candidato correctamente
     */
    public void testReiniciarCostoCampanha( )
    {
        setupEscenario1( );

        candidate.addVoteTelevision( );
        candidate.addVoteRadio( );
        candidate.addVoteInternet( );
        candidate.restartCostCampaign( );

        assertEquals( "No inicializa el costo de campaña a 0", 0.0, candidate.getCostCampaign( ) );
    }
}
