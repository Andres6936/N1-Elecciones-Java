package edu.usc.elecciones.mundo;

/**
 * Es la una urna de votación con tres candidatos.
 */
public class Urn
{

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * El candidato número 1 de la elecciones
     */
    private Candidate candidate1;

    /**
     * El candidato número 2 de la elecciones
     */
    private Candidate candidate2;

    /**
     * El candidato número 3 de la elecciones
     */
    private Candidate candidate3;

    // -----------------------------------------------------------------
    // Constructs
    // -----------------------------------------------------------------

    /**
     * Inicializa los tres candidatos<br>
     * <b>post: </b> Se inicializaron los tres candidatos con los valores por parámetro
     * nombre, apellido, partido político y edad.
     */
    public Urn()
    {
        // Inicializa el candidato 1
        candidate1 = new Candidate( "Frank", "Underwood", "Independiente", 27 );

        // Inicializa el candidato 2
        candidate2 = new Candidate( "Claire", "Underwood", "Revolucionario", 26 );

        // Inicializa el candidato 3
        candidate3 = new Candidate( "Barack", "Obama", "Tradicional", 26 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Devuelve el candidato 1
     *
     * @return Candidato 1
     */
    public Candidate darCandidato1( )
    {
        return candidate1;
    }

    /**
     * Devuelve el candidato 2
     *
     * @return Candidato 2
     */
    public Candidate darCandidato2( )
    {
        return candidate2;
    }

    /**
     * Devuelve el candidato 3
     *
     * @return Candidato 3
     */
    public Candidate darCandidato3( )
    {
        return candidate3;
    }


    /**
     * Ingresa un voto influenciado por la televisión al candidato.
     *
     * @param candidate Candidato a aumentar el voto.
     */
    public void ingresarVotoTelevision( Candidate candidate )
    {
        candidate.addVoteTelevision( );
    }

    /**
     * Ingresa un voto influenciado por la radio al candidato.
     *
     * @param candidate Candidato a aumentar el voto.
     */
    public void ingresarVotoRadio( Candidate candidate )
    {
        candidate.addVoteRadio( );
    }

    /**
     * Incresa un voto influenciado por la internet al candidato.
     *
     * @param candidate Candidato a aumentar el voto.
     */
    public void ingresarVotoInternet( Candidate candidate )
    {
        candidate.addVoteInternet( );
    }

    /**
     * Devuelve el total de votos en la urna
     *
     * @return La sumatoria de los votos de los tres candidatos
     */
    public int calcularTotalVotos( )
    {
        return candidate1.getVotes( ) + candidate2.getVotes( ) + candidate3.getVotes( );
    }

    /**
     * Devuelve el costo promedio de campaña de los candidatos
     *
     * @return La razón de la sumatoria de los costos de campaña de los candidatos y el número total de candidatos.
     */
    public double calcularCostoPromedioCampanha( )
    {
        double total = candidate1.getCostCampaign( ) + candidate2.getCostCampaign( ) + candidate3.getCostCampaign( );

        return total / 3;
    }

    /**
     * Devuelve el porcentaje de votos obtenidos por el candidato.
     *
     * @param candidate Candidato del cual se va a calcular su porcentaje de votos.
     * @return Porcentje de votos obtenidos por el candidato.
     */
    public double calcularPorcentajeVotos( Candidate candidate )
    {
        double numeroVotosCandidato = candidate.getVotes( );
        double votosTotales = calcularTotalVotos( );

        return numeroVotosCandidato / votosTotales * 100;
    }

    /**
     * Restaura la urna al estado inicial, todos los candidatos quedan sin votos y costo de campaña en 0
     */
    public void vaciarUrna( )
    {

        // Reiniciar candidato 1
        candidate1.restartVoteCount( );
        candidate1.restartCostCampaign( );

        // Reiniciar candidato 2
        candidate2.restartVoteCount( );
        candidate2.restartCostCampaign( );

        // Reiniciar candidato 3
        candidate3.restartVoteCount( );
        candidate3.restartCostCampaign( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     *
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     *
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
