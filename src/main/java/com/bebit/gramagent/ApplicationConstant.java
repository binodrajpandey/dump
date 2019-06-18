package com.bebit.gramagent;

/**
 * All the application constants parameters are currently here. It may need to split down to other
 * class if it grows big later.
 * 
 * @author binodraj-pandey
 *
 */
public class ApplicationConstant {
  public static final String RMQ_RET_EXCHANGE_NAME = "gma_ret";
  public static final long RMQ_X_EXPIRES_MSEC = 5 * 60 * 1000;
  public static final String SELECT_USERS_BY_DATES = "selectUsersByDates";
  public static final String REQUEST_NAME = "request_name";
  public static final int INVALID_PARAMETER = 604;
  public static final int ERROR = 666;
  public static final int SUCCEED = 0;
  public static final String UUID = "uuid";
  public static final String CLIENT_ID = "client_id";
  public static final String APP_USER_ID = "app_user_id";
  public static final String STATUS_CODE = "status_code";
  public static final String ERROR_CODE = "error_code";
  public static final String ERROR_MESSAGE = "error_msg";

  public static final String REQUEST_EXCHANGE_NAME = "req_requested_exchange_name";
  public static final String REQUEST_QUEUE_NAME = "req_requested_queue_name";
  public static final String REQUEST_ROUTING_KEY_NAME = "req_requested_routing_key_name";

  public static final String FILTER_EXCHANGE_NAME = "req_filtered_exchange_name";
  public static final String FILTER_QUEUE_NAME = "req_filtered_queue_name";
  public static final String FILTER_ROUTING_KEY_NAME = "req_filtered_routing_key_name";

  public static final String RMQ_ROUTING_KEY = "shared_routing_key";

  /**
   * Header portion of the name of the Exchange for CV refinement user request
   */
  public static final String RMQ_REQUESTED_USER_EXCHANGE_NAME_HEADER =
      "gma_requested_user_exchange";
  /**
   * 
   * Header portion of the name of the queue for the CV refinement user request
   */
  public static final String RMQ_REQUESTED_USER_QUEUE_NAME_HEADER = "gma_requested_user_queue";

  /**
   * Header portion of Exchange's name for restricted user requests
   */
  public static final String RMQ_FILTERED_USER_EXCHANGE_NAME_HEADER = "gma_filtered_user_exchange";
  /**
   * 
   * Header portion of queue's name for restricted user requests
   */
  public static final String RMQ_FILTERED_USER_QUEUE_NAME_HEADER = "gma_filtered_user_queue";

  
  // TODO In the existing system this value is passed as common: proc_name: __PROCESS_NAME__ from
  // gram-agent.yaml file. It may have some meaning and may be dynamic. If so it should be moved to
  // properties.yml
  // file.
  public static final String PROCESS_NAME = "__PROCESS_NAME__";

}
