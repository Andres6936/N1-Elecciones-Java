package elections.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import elections.mundo.Candidate;
import elections.mundo.Urn;

@SuppressWarnings( "serial" )
public class InterfaceElections extends JFrame
{
    // -----------------------------------------------------------------
    // Fields
    // -----------------------------------------------------------------

    /**
     * World's leading class
     */
    private Urn urn;

    // -----------------------------------------------------------------
    // Attributes of the interface
    // -----------------------------------------------------------------

    /**
     * Candidate Panel Frank.
     */
    private PanelCandidate panelFrank;

    /**
     * Candidate Panel Claire.
     */
    private PanelCandidate panelClaire;

    /**
     * Candidate Panel Barack.
     */
    private PanelCandidate panelBarack;

    /**
     * Panel with the totals of the urn.
     */
    private PanelUrn panelUrn;

    // -----------------------------------------------------------------
    // Constructs
    // -----------------------------------------------------------------

    /**
     * Construct where the interface is assembled.
     */
    private InterfaceElections( )
    {
        urn = new Urn( );

        setTitle( "Elecciones Usaca" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 800, 600 );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setResizable( false );

        try
        {
            UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
        }
        catch ( ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException e )
        {
            e.printStackTrace( );
        }

        // Creation of the panels here

        // Panel with the image
        PanelImage panelImage = new PanelImage( );
        getContentPane( ).add( panelImage, BorderLayout.NORTH );

        // Build the panel with the three candidates

        JPanel panelCandidatos = new JPanel( );
        panelCandidatos.setLayout( new GridLayout( 1, 3 ) );
        getContentPane( ).add( panelCandidatos, BorderLayout.CENTER );

        ImageIcon imageFrancis = new ImageIcon( "data/Francis.jpg" );
        ImageIcon imageClaire = new ImageIcon( "data/Claire.jpg" );
        ImageIcon imageObama = new ImageIcon( "data/Obama.jpg" );

        panelFrank = new PanelCandidate( this, urn.getFrank( ), imageFrancis );
        panelCandidatos.add( panelFrank );
        panelClaire = new PanelCandidate( this, urn.getClaire( ), imageClaire );
        panelCandidatos.add( panelClaire );
        panelBarack = new PanelCandidate( this, urn.getBarack( ), imageObama );
        panelCandidatos.add( panelBarack );

        JPanel panelInferior = new JPanel( );
        panelInferior.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelInferior, BorderLayout.SOUTH );
        panelUrn = new PanelUrn( );
        panelInferior.add( panelUrn, BorderLayout.CENTER );

        // Panel with extensions
        PanelExtension panelExtension = new PanelExtension( this );
        panelInferior.add( panelExtension, BorderLayout.SOUTH );
        setLocationRelativeTo( null );

        update( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Adds a vote to a candidate depending on the medium that most influenced the vote.
     *
     * @param candidate Candidate to add the vote
     */
    public void addVoteCandidate( Candidate candidate )
    {

        Object[] possibilities = { "Televisión", "Radio", "Internet" };
        String influencia = ( String ) JOptionPane.showInputDialog( this,
                                                                    "¿Que medio influenció mas en usted para votar por este candidato?",
                                                                    "Influencia", JOptionPane.QUESTION_MESSAGE,
                                                                    null, possibilities, "Televisión" );

        if ( influencia != null )
        {
            if ( influencia.equals( "Televisión" ) )
            {
                urn.addVoteTelevision( candidate );
            }
            else if ( influencia.equals( "Radio" ) )
            {
                urn.addVoteRadio( candidate );
            }
            else if ( influencia.equals( "Internet" ) )
            {
                urn.addVoteInternet( candidate );
            }
        }
        update( );

    }

    /**
     * Clear the Urn.
     */
    public void clearUrn( )
    {
        urn.clearUrn( );
        update( );

    }

    /**
     * The percentage of votes of a given candidate is reported.
     *
     * @param candidate Candidate whose percentage of votes will be shown.
     */
    public void showDialogPercentageVotes( Candidate candidate )
    {
        JOptionPane.showMessageDialog( this,
                                       "Porcentaje de votos: " +
                                               formatRealNumerical( urn.calculatePercentageVotes( candidate ) ) +
                                               " %", "Candidato " +
                                               candidate.getName( ), JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Total votes of the urn.
     *
     * @return The total number of votes contained in the urn.
     */
    public int getTotalVotesUrn( )
    {
        return urn.calculateTotalVotes( );
    }

    // -----------------------------------------------------------------
    // Extension Point
    // -----------------------------------------------------------------

    /**
     * Method for Extension 1
     */
    public void reqFuncOption1( )
    {
        String resultado = urn.method1( );
        JOptionPane.showMessageDialog( this, resultado,
                                       "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Method for Extension 2
     */
    public void reqFuncOption2( )
    {
        String resultado = urn.method2( );
        JOptionPane.showMessageDialog( this, resultado,
                                       "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * This method executes the application, creating a new interface.
     *
     * @param args Application arguments.
     */
    public static void main( String[] args )
    {
        InterfaceElections interfaz = new InterfaceElections( );
        interfaz.setVisible( true );
    }

    /**
     * Updates the interface display.<br>
     * <b>post: </b> The display is updated.
     */
    private void update( )
    {
        panelFrank.actualizar( urn.getFrank( ) );
        panelClaire.actualizar( urn.getClaire( ) );
        panelBarack.actualizar( urn.getBarack( ) );
        panelUrn.actualizar( urn );
    }

    /**
     * Format a real numeric value to present in the interface.<br>
     *
     * @param valor The numerical value to be formatted.
     * @return String with value formatted with dots and signs.
     */
    private String formatRealNumerical( double valor )
    {
        DecimalFormat df = ( DecimalFormat ) NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}
