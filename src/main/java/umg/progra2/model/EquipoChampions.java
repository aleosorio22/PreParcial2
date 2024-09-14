package umg.progra2.model;

public class EquipoChampions {
    private int idEquipo;
    private String nombre;
    private String pais;
    private String ciudad;
    private String estadio;
    private int fundacion;
    private String entrenador;
    private String webOficial;
    private String facebook;
    private String twitter;
    private String instagram;
    private String patrocinadorPrincipal;

    public EquipoChampions(int idEquipo, String nombre, String pais, String ciudad, String estadio, int fundacion, String entrenador, String webOficial, String facebook, String twitter, String instagram, String patrocinadorPrincipal) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.fundacion = fundacion;
        this.entrenador = entrenador;
        this.webOficial = webOficial;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.patrocinadorPrincipal = patrocinadorPrincipal;
    }

    // Getters
    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getFundacion() {
        return fundacion;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public String getWebOficial() {
        return webOficial;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getPatrocinadorPrincipal() {
        return patrocinadorPrincipal;
    }

    // Setters
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public void setWebOficial(String webOficial) {
        this.webOficial = webOficial;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setPatrocinadorPrincipal(String patrocinadorPrincipal) {
        this.patrocinadorPrincipal = patrocinadorPrincipal;
    }
}
