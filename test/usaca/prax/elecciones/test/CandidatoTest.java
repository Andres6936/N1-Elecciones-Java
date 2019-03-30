package usaca.prax.elecciones.test;

import usaca.prax.elecciones.mundo.Candidato;
import junit.framework.TestCase;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Candidato estén correctamente implementados
 */
public class CandidatoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Candidato candidato;

    // -----------------------------------------------------------------
    // Métodos
    // -------------------------

    /**
     * Construye un nuevo Candidato
     */
    private void setupEscenario1( )
    {
        candidato = new Candidato( "Felipe", "Pitti", "Independiente", 27 );
    }

    /**
     * Prueba 1 - Inicializar los datos del candidato correctamente
     */
    public void testInicializar( )
    {
        setupEscenario1( );

        assertEquals( "No se crea con el nombre dado por parámetro", "Felipe", candidato.getNombre( ) );
        assertEquals( "No se crea con el apellido dado por parámetro", "Pitti", candidato.getApellido( ) );
        assertEquals( "No se crea con el partido político dado por parámetro", "Independiente", candidato.getPartidoPolitico( ) );
        assertEquals( "No se crea con la edad dada por parámetro", 27, candidato.getEdad( ) );
        assertEquals( "No se crea con el costo de campaña en 0", 0, candidato.getCostoCampanha( ) );
        assertEquals( "No se crea con el número de votos en 0", 0, candidato.getVotos( ) );
    }

    /**
     * Prueba 2 - Agregar un voto al candidato influenciado por la televisión correctamente
     */
    public void testAgregarVotoTelevision( )
    {
        setupEscenario1( );

        candidato.agregarVotoTelevision( );
        assertTrue( "No aumenta el número de votos en 1", candidato.getVotos( ) == 1 );
        assertTrue( "No aumenta el costo de campaña en 1000", candidato.getCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 3 - Agregar un voto al candidato influenciado por la radio correctamente
     */
    public void testAgregarVotoRadio( )
    {
        setupEscenario1( );

        candidato.agregarVotoRadio( );
        assertTrue( "No aumenta el número de votos en 1", candidato.getVotos( ) == 1 );
        assertTrue( "No aumenta el costo de campaña en 500", candidato.getCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 4 - Agregar un voto al candidato influenciado por Internet correctamente
     */
    public void testAgregarVotoInternet( )
    {
        setupEscenario1( );

        candidato.agregarVotoInternet( );
        assertTrue( "No aumenta el número de votos en 1", candidato.getVotos( ) == 1 );
        assertTrue( "No aumenta el costo de campaña en 100", candidato.getCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 5 - Reiniciar los votos del candidato correctamente
     */
    public void testReiniciarConteoVotos( )
    {
        setupEscenario1( );

        candidato.agregarVotoTelevision( );
        candidato.agregarVotoRadio( );
        candidato.agregarVotoInternet( );
        candidato.reiniciarConteoVotos( );

        assertTrue( "No inicializa el número de votos a 0", candidato.getVotos( ) == 0 );
    }

    /**
     * Prueba 6 - Reiniciar el costo de campaña del candidato correctamente
     */
    public void testReiniciarCostoCampanha( )
    {
        setupEscenario1( );

        candidato.agregarVotoTelevision( );
        candidato.agregarVotoRadio( );
        candidato.agregarVotoInternet( );
        candidato.reiniciarCostoCampanha( );

        assertTrue( "No inicializa el costo de campaña a 0", candidato.getCostoCampanha( ) == 0 );
    }
}
