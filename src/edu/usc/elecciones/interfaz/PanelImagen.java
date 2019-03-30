package edu.usc.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con la imagen.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del Panel
     */
    public PanelImagen( )
    {
        setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );

        // Etiqueta Logo de las elecciones. Logos basados en la historieta Mafalda
        ImageIcon icono = new ImageIcon( "data/Encabezado.png" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( new ImageIcon( "data/Encabezado.jpg" ) );

        add( etiquetaImagen, BorderLayout.CENTER );

    }

}
