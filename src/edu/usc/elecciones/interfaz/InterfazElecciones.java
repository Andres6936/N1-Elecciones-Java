package edu.usc.elecciones.interfaz;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

import edu.usc.elecciones.mundo.Candidato;
import edu.usc.elecciones.mundo.Urna;

@SuppressWarnings( "serial" )
public class InterfazElecciones extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Urna urna;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen
     */
    private PanelImagen panelImagen;

    /**
     * Panel del candidato 1.
     */
    private PanelCandidato panelCandidato1;

    /**
     * Panel del candidato 2.
     */
    private PanelCandidato panelCandidato2;

    /**
     * Panel del candidato 3.
     */
    private PanelCandidato panelCandidato3;

    /**
     * Panel con los totales de la urna.
     */
    private PanelUrna panelUrna;

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
    public InterfazElecciones( )
    {
        // Crea la clase principal
        urna = new Urna( );
        urna.inicializar( );

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
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        // Construye el panel con los tres candidatos

        JPanel panelCandidatos = new JPanel( );
        panelCandidatos.setLayout( new GridLayout( 1, 3 ) );
        getContentPane( ).add( panelCandidatos, BorderLayout.CENTER );

        ImageIcon imageFrancis = new ImageIcon( "data/Francis.jpg" );
        ImageIcon imageClaire = new ImageIcon( "data/Claire.jpg" );
        ImageIcon imageObama = new ImageIcon( "data/Obama.jpg" );

        panelCandidato1 = new PanelCandidato( this, urna.darCandidato1(), imageFrancis );
        panelCandidatos.add( panelCandidato1 );
        panelCandidato2 = new PanelCandidato( this, urna.darCandidato2(), imageClaire );
        panelCandidatos.add( panelCandidato2 );
        panelCandidato3 = new PanelCandidato( this, urna.darCandidato3(), imageObama );
        panelCandidatos.add( panelCandidato3 );

        JPanel panelInferior = new JPanel( );
        panelInferior.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelInferior, BorderLayout.SOUTH );
        panelUrna = new PanelUrna( );
        panelInferior.add( panelUrna, BorderLayout.CENTER );
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
     * @param candidato Candidato a adicionar el voto
     */
    public void adicionarVotoCandidato( Candidato candidato )
    {

        Object[] possibilities = { "Televisión", "Radio", "Internet" };
        String influencia = ( String ) JOptionPane.showInputDialog( this, "¿Que medio influenció mas en usted para votar por este candidato?", "Influencia", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Televisión" );

        if ( influencia != null )
        {
            if ( influencia.equals( "Televisión" ) )
            {
                urna.ingresarVotoTelevision( candidato );
            }
            else if ( influencia.equals( "Radio" ) )
            {
                urna.ingresarVotoRadio( candidato );
            }
            else if ( influencia.equals( "Internet" ) )
            {
                urna.ingresarVotoInternet( candidato );
            }
        }
        actualizar( );

    }

    /**
     * Restaura la urna
     */
    public void vaciarUrna( )
    {
        urna.vaciarUrna( );
        actualizar( );

    }

    /**
     * Se informa el porcentaje de votos de un candidato dado.
     *
     * @param candidato Candidato del cual se va a mostrar el porcentaje de votos
     */
    public void mostrarDialogoPorcentajeVotos( Candidato candidato )
    {
        JOptionPane.showMessageDialog( this, "Porcentaje de votos: " + formatearValorReal( urna.calcularPorcentajeVotos( candidato ) ) + " %", "Candidato " + candidato.getNombre(), JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Total de votos de la urna
     *
     * @return El total de votos que contiene la urna
     */
    public int darTotalVotosUrna( )
    {
        return urna.calcularTotalVotos( );
    }
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = urna.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = urna.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     *
     * @param args
     */
    public static void main( String[] args )
    {
        InterfazElecciones interfaz = new InterfazElecciones( );
        interfaz.setVisible( true );
    }

    /**
     * Actualiza la visualización de la interfaz <br>
     * <b>post: </b> Se actualiza la visualización
     */
    private void actualizar( )
    {
        panelCandidato1.actualizar( urna.darCandidato1( ) );
        panelCandidato2.actualizar( urna.darCandidato2( ) );
        panelCandidato3.actualizar( urna.darCandidato3( ) );
        panelUrna.actualizar( urna );
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
