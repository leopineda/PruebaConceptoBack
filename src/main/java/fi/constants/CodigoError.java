package fi.constants;

public enum CodigoError {
    GES_REP_0001("Los parametros no son correctos", TipoError.CLIENTE, SeveridadError.BAJA),
    GES_REP_0002("Las calificaciones que desea consultar no existen", TipoError.CLIENTE, SeveridadError.MEDIA);
    /**
     * Descripción del error
     */
    private String descripcion;

    /**
     * Tipo de error
     */
    private TipoError tipoError;

    /**
     * Severidad del error
     */
    private SeveridadError severidadError;

    /**
     * Constructor
     *
     * @param descripcion Descripción del error
     * @param tipoError Tipo de error
     * @param severidadError Severidad del error
     */
    CodigoError(String descripcion, TipoError tipoError, SeveridadError severidadError) {
        this.descripcion = descripcion;
        this.tipoError = tipoError;
        this.severidadError = severidadError;
    }

    /**
     * Recupera el valor de {@code codigo}
     *
     * @return Valor de {@code codigo}
     */
    public String getCodigo() {
        return name();
    }

    /**
     * Recupera el valor de {@code descripcion}
     *
     * @return Valor de {@code descripcion}
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Recupera el valor de {@code tipoError}
     *
     * @return Valor de {@code tipoError}
     */
    public TipoError getTipoError() {
        return tipoError;
    }

    /**
     * Recupera el valor de {@code severidadError}
     *
     * @return Valor de {@code severidadError}
     */
    public SeveridadError getSeveridadError() {
        return severidadError;
    }
}
