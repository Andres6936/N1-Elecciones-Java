package edu.usc.elecciones.mundo;

/**
 * It's a voting box with three candidates.
 */
public class Urn
{

    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * Candidate in the position number 1 in the election.
     */
    private Candidate frank;

    /**
     * Candidate in the position number 2 in the election.
     */
    private Candidate claire;

    /**
     * Candidate in the position number 3 in the election.
     */
    private Candidate barack;

    // -----------------------------------------------------------------
    // Constructs
    // -----------------------------------------------------------------

    /**
     * Initializes the three candidates.<br>
     * <b>post: </b> The three candidates were initialised with the values per parameter
     * name, last name, political party and age.
     */
    public Urn()
    {
        // Inicializa el candidato 1
        frank = new Candidate( "Frank", "Underwood", "Independiente", 27 );

        // Inicializa el candidato 2
        claire = new Candidate( "Claire", "Underwood", "Revolucionario", 26 );

        // Inicializa el candidato 3
        barack = new Candidate( "Barack", "Obama", "Tradicional", 26 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Return candidate Frank.
     *
     * @return Candidate Frank.
     */
    public Candidate getFrank( )
    {
        return frank;
    }

    /**
     * Return candidate Claire.
     *
     * @return Candidate Claire.
     */
    public Candidate getClaire( )
    {
        return claire;
    }

    /**
     * Return candidate Barack.
     *
     * @return Candidate Barack.
     */
    public Candidate getBarack( )
    {
        return barack;
    }


    /**
     * Add a television-influenced vote to the candidate.
     *
     * @param candidate Candidate to increase the vote.
     */
    public void addVoteTelevision( Candidate candidate )
    {
        candidate.addVoteTelevision( );
    }

    /**
     * Add a radio-influenced vote to the candidate.
     *
     * @param candidate Candidate to increase the vote.
     */
    public void addVoteRadio( Candidate candidate )
    {
        candidate.addVoteRadio( );
    }

    /**
     * Add an Internet-influenced vote to the candidate.
     *
     * @param candidate Candidate to increase the vote.
     */
    public void addVoteInternet( Candidate candidate )
    {
        candidate.addVoteInternet( );
    }

    /**
     * Returns the total number of votes in the urn.
     *
     * @return The sum of the votes of the three candidates
     */
    public int calculateTotalVotes( )
    {
        return frank.getVotes( ) + claire.getVotes( ) + barack.getVotes( );
    }

    /**
     * Returns the candidates' average campaign cost.
     *
     * @return The reason for the sum of the candidates' campaign costs and the total number of candidates.
     */
    public double calculateAverageCampaignCost( )
    {
        double total = frank.getCostCampaign( ) + claire.getCostCampaign( ) + barack.getCostCampaign( );

        return total / 3;
    }

    /**
     * Returns the percentage of votes obtained by the candidate.
     *
     * @param candidate Candidate whose percentage of votes will be calculated.
     * @return Percentage of votes obtained by the candidate.
     */
    public double calculatePercentageVotes( Candidate candidate )
    {
        double numeroVotosCandidato = candidate.getVotes( );
        double votosTotales = calculateTotalVotes( );

        return numeroVotosCandidato / votosTotales * 100;
    }

    /**
     * Restores the urn to the initial state, all candidates are left without votes and campaign cost at 0.
     */
    public void clearUrn( )
    {

        // Restart candidate Frank.
        frank.restartVoteCount( );
        frank.restartCostCampaign( );

        // Restart candidate Claire.
        claire.restartVoteCount( );
        claire.restartCostCampaign( );

        // Restart candidate Barack.
        barack.restartVoteCount( );
        barack.restartCostCampaign( );
    }

    // -----------------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------------

    /**
     * Method for Extension 1.
     *
     * @return answer.
     */
    public String method1( )
    {
        return "Respuesta 1";
    }

    /**
     * Method for Extension 2.
     *
     * @return answer.
     */
    public String method2( )
    {
        return "Respuesta 2";
    }

}
