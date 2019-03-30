package usaca.prax.elecciones.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones.
 */
@SuppressWarnings("serial")
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Vaciar Urna
     */
    private static final String VACIAR_URNA = "VACIAR_URNA";

    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazElecciones principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón VaciarUrna
     */
    private JButton btnVaciarUrna;

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension( InterfazElecciones ventana )
    {
        principal = ventana;

        setBackground( Color.WHITE );
        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 3 ) );

        // Botón vaciar urna
        btnVaciarUrna = new JButton( "Vaciar Urna" );
        btnVaciarUrna.setBackground( new Color( 246, 34, 23 ) );
        btnVaciarUrna.setForeground( Color.WHITE );
        btnVaciarUrna.setActionCommand( VACIAR_URNA );
        btnVaciarUrna.addActionListener( this );
        add( btnVaciarUrna );

        // Botón opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setBackground( new Color( 21, 137, 255 ) );
        btnOpcion1.setForeground( Color.WHITE );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setBackground( new Color( 21, 137, 255 ) );
        btnOpcion2.setForeground( Color.WHITE );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( OPCION_1.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( VACIAR_URNA.equals( e.getActionCommand( ) ) )
        {

            principal.vaciarUrna( );
        }
    }
}
