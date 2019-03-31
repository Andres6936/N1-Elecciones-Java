package edu.usc.elecciones.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.usc.elecciones.mundo.Urn;

/**
 * Panel que contiene la información de la urna de votos en las elecciones cupi2
 */
@SuppressWarnings("serial")
public class PanelUrn extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta total votos en urna.
     */
    private JLabel etiquetaTotalVotos;

    /**
     * Etiqueta Promedio costo de campaña.
     */
    private JLabel etiquetaPromedioCostoCampanha;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    public PanelUrn( )
    {
        setBorder( new TitledBorder( "Totales" ) );
        setLayout( new GridLayout( 2, 1 ) );
        setBackground( Color.WHITE );

        // Etiqueta total votos
        etiquetaTotalVotos = new JLabel( "Total Votos: " );
        etiquetaTotalVotos.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTotalVotos.setForeground( Color.BLUE.darker( ) );
        etiquetaTotalVotos.setFont( new Font( "Tahoma", Font.BOLD, 24 ) );

        // Etiqueta total costo de campaña
        etiquetaPromedioCostoCampanha = new JLabel( "Costo Promedio Campaña: $" );
        etiquetaPromedioCostoCampanha.setHorizontalAlignment( JLabel.CENTER );
        etiquetaPromedioCostoCampanha.setForeground( Color.BLUE.darker( ) );
        etiquetaPromedioCostoCampanha.setFont( new Font( "Tahoma", Font.BOLD, 24 ) );

        add( etiquetaTotalVotos );
        add( etiquetaPromedioCostoCampanha );
        setPreferredSize( new Dimension( 78, 78 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información
     * @param urn Urna de la cual se va a mostrar la información. urna != null.
     */
    public void actualizar( Urn urn )
    {
        etiquetaTotalVotos.setText( "Total Votos: " + urn.calcularTotalVotos( ) );
        etiquetaPromedioCostoCampanha.setText( "Costo Promedio Campaña: $" + formatearValorReal( urn.calcularCostoPromedioCampanha( ) ) );

    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}
