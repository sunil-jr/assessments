package com.spring.vehicleAssessment.route;

public class Route {

    public static final String BASE_URL = "/assessment";

    //vehicle

    public static final String VEHICLE = BASE_URL + "/vehicle";

    public static final String ADD_VEHICLE = VEHICLE + "/add";

    public static final String UPDATE_VEHICLE = VEHICLE +"/{id}"+ "/update";

    public static final String GET_ALL = VEHICLE + "/getall";

    public static final String GET_BY_ID = VEHICLE + "/{id}";

    public static final String GET_BY_ACTIVE = VEHICLE +"/active";

    public static final String ACTIVATE = VEHICLE+ "/{id}" + "/activate";

    public static final String DEACTIVATE = VEHICLE+ "/{id}" + "/deactivate";

    public static final String DELETE_BY_ID = VEHICLE + "/{id}" +"/delete";
}
