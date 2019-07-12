package edu.usc.elecciones.interfaz;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

import edu.usc.elecciones.mundo.Candidate;
import edu.usc.elecciones.mundo.Urn;

@SuppressWarnings( "serial" )
public class InterfaceElections extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Urn urn;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen
     */
    private PanelImage panelImage;

    /**
     * Panel del candidato 1.
     */
    private PanelCandidate panelCandidate1;

    /**
     * Panel del candidato 2.
     */
    private PanelCandidate panelCandidate2;

    /**
     * Panel del candidato 3.
     */
    private PanelCandidate panelCandidate3;

    /**
     * Panel con los totales de la urna.
     */
    private PanelUrn panelUrn;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor donde se arma la interfaz.
     */
    private InterfaceElections( )
    {
        // Crea la clase principal
        urn = new Urn( );

        // Construye la forma
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

        // Creación de los paneles aquí

        // Panel imagen
        panelImage = new PanelImage( );
        getContentPane( ).add( panelImage, BorderLayout.NORTH );

        // Construye el panel con los tres candidatos

        JPanel panelCandidatos = new JPanel( );
        panelCandidatos.setLayout( new GridLayout( 1, 3 ) );
        getContentPane( ).add( panelCandidatos, BorderLayout.CENTER );

        ImageIcon imageFrancis = new ImageIcon( "data/Francis.jpg" );
        ImageIcon imageClaire = new ImageIcon( "data/Claire.jpg" );
        ImageIcon imageObama = new ImageIcon( "data/Obama.jpg" );

        panelCandidate1 = new PanelCandidate( this, urn.darCandidato1( ), imageFrancis );
        panelCandidatos.add( panelCandidate1 );
        panelCandidate2 = new PanelCandidate( this, urn.darCandidato2( ), imageClaire );
        panelCandidatos.add( panelCandidate2 );
        panelCandidate3 = new PanelCandidate( this, urn.darCandidato3( ), imageObama );
        panelCandidatos.add( panelCandidate3 );

        JPanel panelInferior = new JPanel( );
        panelInferior.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelInferior, BorderLayout.SOUTH );
        panelUrn = new PanelUrn( );
        panelInferior.add( panelUrn, BorderLayout.CENTER );
        panelExtension = new PanelExtension( this );
        panelInferior.add( panelExtension, BorderLayout.SOUTH );
        setLocationRelativeTo( null );

        actualizar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Adiciona un voto a un candidato dependiendo del medio que más
     * influenció el voto.
     *
     * @param candidate Candidato a adicionar el voto
     */
    public void adicionarVotoCandidato( Candidate candidate )
    {

        Object[] possibilities = { "Televisión", "Radio", "Internet" };
        String influencia = ( String ) JOptionPane.showInputDialog( this, "¿Que medio influenció mas en usted para votar por este candidato?", "Influencia", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Televisión" );

        if ( influencia != null )
        {
            if ( influencia.equals( "Televisión" ) )
            {
                urn.ingresarVotoTelevision( candidate );
            }
            else if ( influencia.equals( "Radio" ) )
            {
                urn.ingresarVotoRadio( candidate );
            }
            else if ( influencia.equals( "Internet" ) )
            {
                urn.ingresarVotoInternet( candidate );
            }
        }
        actualizar( );

    }

    /**
     * Restaura la urna
     */
    public void vaciarUrna( )
    {
        urn.vaciarUrna( );
        actualizar( );

    }

    /**
     * Se informa el porcentaje de votos de un candidato dado.
     *
     * @param candidate Candidato del cual se va a mostrar el porcentaje de votos
     */
    public void mostrarDialogoPorcentajeVotos( Candidate candidate )
    {
        JOptionPane.showMessageDialog( this, "Porcentaje de votos: " + formatearValorReal( urn.calcularPorcentajeVotos( candidate ) ) + " %", "Candidato " + candidate.getName( ), JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Total de votos de la urna
     *
     * @return El total de votos que contiene la urna
     */
    public int darTotalVotosUrna( )
    {
        return urn.calcularTotalVotos( );
    }
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = urn.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = urn.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     *
     * @param args Application arguments.
     */
    public static void main( String[] args )
    {
        InterfaceElections interfaz = new InterfaceElections( );
        interfaz.setVisible( true );
    }

    /**
     * Actualiza la visualización de la interfaz <br>
     * <b>post: </b> Se actualiza la visualización
     */
    private void actualizar( )
    {
        panelCandidate1.actualizar( urn.darCandidato1( ) );
        panelCandidate2.actualizar( urn.darCandidato2( ) );
        panelCandidate3.actualizar( urn.darCandidato3( ) );
        panelUrn.actualizar( urn );
    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz <br>
     *
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat ) NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}
