/*
 * This file is generated by jOOQ.
 */
package br.com.evandropires.debitauthorizer.jooq.routines;


import br.com.evandropires.debitauthorizer.jooq.Public;

import javax.annotation.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class KillAllConnections extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1676714627;

    /**
     * The parameter <code>public.kill_all_connections.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB, false, false);

    /**
     * Create a new routine call instance
     */
    public KillAllConnections() {
        super("kill_all_connections", Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
    }
}
