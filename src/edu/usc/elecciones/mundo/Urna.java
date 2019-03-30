package edu.usc.elecciones.mundo;

import org.jetbrains.annotations.NotNull;

/**
 * Es la una urna de votación con tres candidatos.
 */
public class Urna
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El candidato número 1 de la elecciones
     */
    private Candidato candidato1;

    /**
     * El candidato número 2 de la elecciones
     */
    private Candidato candidato2;

    /**
     * El candidato número 3 de la elecciones
     */
    private Candidato candidato3;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Inicializa los tres candidatos<br>
     * <b>post: </b> Se inicializaron los tres candidatos con los valores por parámetro
     * nombre, apellido, partido político y edad.
     */
    public void inicializar( )
    {

        // Inicializa el candidato 1
        candidato1 = new Candidato( "Frank", "Underwood", "Independiente", 27 );

        // Inicializa el candidato 2
        candidato2 = new Candidato( "Claire", "Underwood", "Revolucionario", 26 );

        // Inicializa el candidato 3
        candidato3 = new Candidato( "Barack", "Obama", "Tradicional", 26 );
    }

    /**
     * Devuelve el candidato 1
     * @return Candidato 1
     */
    public Candidato darCandidato1( )
    {
        return candidato1;
    }

    /**
     * Devuelve el candidato 2
     * @return Candidato 2
     */
    public Candidato darCandidato2( )
    {
        return candidato2;
    }

    /**
     * Devuelve el candidato 3
     * @return Candidato 3
     */
    public Candidato darCandidato3( )
    {
        return candidato3;
    }


    /**
     * Ingresa un voto influenciado por la televisión al candidato.
     * @param candidato Candidato a aumentar el voto.
     */
    public void ingresarVotoTelevision(Candidato candidato)
    {
        candidato.agregarVotoTelevision();
    }

    /**
     * Ingresa un voto influenciado por la radio al candidato.
     * @param candidato Candidato a aumentar el voto.
     */
    public void ingresarVotoRadio(Candidato candidato)
    {
        candidato.agregarVotoRadio();
    }

    /**
     * Incresa un voto influenciado por la internet al candidato.
     * @param candidato Candidato a aumentar el voto.
     */
    public void ingresarVotoInternet(Candidato candidato)
    {
        candidato.agregarVotoInternet();
    }

    /**
     * Devuelve el total de votos en la urna
     * @return La sumatoria de los votos de los tres candidatos
     */
    public int calcularTotalVotos( )
    {
        return candidato1.getVotos( ) + candidato2.getVotos( ) + candidato3.getVotos( );
    }

    /**
     * Devuelve el costo promedio de campaña de los candidatos
     * @return La razón de la sumatoria de los costos de campaña de los candidatos y el número total de candidatos.
     */
    public double calcularCostoPromedioCampanha( )
    {

        double total;
        double promedio;

        total = candidato1.getCostoCampanha( ) + candidato2.getCostoCampanha( ) + candidato3.getCostoCampanha( );
        promedio = total / 3;

        return promedio;

    }

    /**
     * Devuelve el porcentaje de votos obtenidos por el candidato.
     * @param candidato Candidato del cual se va a calcular su porcentaje de votos.
     * @return Porcentje de votos obtenidos por el candidato.
     */
    public double calcularPorcentajeVotos( Candidato candidato )
    {
        double numeroVotosCandidato = candidato.getVotos();
        double votosTotales = calcularTotalVotos();

        return numeroVotosCandidato / votosTotales * 100;
    }

    /**
     * Restaura la urna al estado inicial, todos los candidatos quedan sin votos y costo de campaña en 0
     */
    public void vaciarUrna( )
    {

        // Reiniciar candidato 1
        candidato1.reiniciarConteoVotos( );
        candidato1.reiniciarCostoCampanha( );

        // Reiniciar candidato 2
        candidato2.reiniciarConteoVotos( );
        candidato2.reiniciarCostoCampanha( );

        // Reiniciar candidato 3
        candidato3.reiniciarConteoVotos( );
        candidato3.reiniciarCostoCampanha( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    @NotNull
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    @NotNull
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
