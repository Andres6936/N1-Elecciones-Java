package elections.mundo;

/**
 * Candidate of the election.
 */
public class Candidate
{
    //-------------------------------------------
    // Fields
    //-------------------------------------------

    /**
     * Candidate's name.
     */
    private String name;

    /**
     * Candidate's last name.
     */
    private String lastName;

    /**
     * Candidate's political party.
     */
    private String politicalParty;

    /**
     * Candidate's age.
     */
    private int age;

    /**
     * Candidate's campaign cost.
     */
    private double costCampaign;

    /**
     * Number of votes of the candidate.
     */
    private int votes;

    //-------------------------------------------
    // Construct
    //-------------------------------------------

    /**
     * It initializes the applicant's data with the values that come by parameter.<br>
     * <b>post: </b> The campaign cost was initialised at zero.<br>
     * <b>post: </b> The number of votes was initialized to zero.<br>
     *
     * @param nName             Candidate's name.
     * @param nLastName         Candidate's last name.
     * @param nPoliticalParty   Candidate's political party.
     * @param nAge              Candidate's age.
     */
    public Candidate( String nName, String nLastName, String nPoliticalParty, int nAge )
    {
        name = nName;
        lastName = nLastName;
        politicalParty = nPoliticalParty;
        age = nAge;
        costCampaign = 0;
        votes = 0;
    }

    //-------------------------------------------
    // Methods
    //-------------------------------------------

    /**
     * Returns the candidate's name.
     *
     * @return Candidate's name.
     */
    public String getName( )
    {
        return name;
    }

    /**
     * Returns the candidate's last name.
     *
     * @return Candidate's last name.
     */
    public String getLastName( )
    {
        return lastName;
    }

    /**
     * Returns the candidate's political party.
     *
     * @return Candidate's political party.
     */
    public String getPoliticalParty( )
    {
        return politicalParty;
    }

    /**
     * Returns the candidate's age.
     *
     * @return Candidate's age.
     */
    public int getAge( )
    {
        return age;
    }

    /**
     * Returns the candidate's campaign cost.
     *
     * @return Candidate's campaign cost.
     */
    public double getCostCampaign( )
    {
        return costCampaign;
    }

    /**
     * Returns the candidate's number of votes.
     *
     * @return Number of votes of the candidate.
     */
    public int getVotes( )
    {
        return votes;
    }

    /**
     * A vote is added to the candidate.<br>
     * <b>post: </b> The number of votes was modified by increasing the existing number by 1.
     */
    private void addVote( )
    {
        votes = votes + 1;
    }

    /**
     * Add a vote influenced by television.<br>
     * <b>post: </b> Add to the cost of the campaign the sum of $1000 and increase the number of votes by 1.
     */
    public void addVoteTelevision( )
    {
        costCampaign = costCampaign + 1000;
        addVote( );
    }

    /**
     * Add a vote influenced by radio.<br>
     * <b>post: </b> Add $500 to the cost of the campaign and increase the number of votes by 1.
     */
    public void addVoteRadio( )
    {
        costCampaign = costCampaign + 500;
        addVote( );
    }

    /**
     * Add an Internet-influenced vote.<br>
     * <b>post: </b> Add to the cost of the campaign the sum of $100 and increase the number of votes by 1.
     */
    public void addVoteInternet( )
    {
        costCampaign = costCampaign + 100;
        addVote( );
    }

    /**
     * The vote count is restarted.<br>
     * <b>post: </b> votes = 0.
     */
    public void restartVoteCount( )
    {
        votes = 0;
    }

    /**
     * The campaign cost is restarted.<br>
     * <b>post: </b> costCampaign = 0.
     */
    public void restartCostCampaign( )
    {
        costCampaign = 0;
    }
}
