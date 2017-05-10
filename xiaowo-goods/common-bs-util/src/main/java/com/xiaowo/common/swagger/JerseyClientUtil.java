package com.xiaowo.common.swagger;

import com.xiaowo.common.exception.ErrorCode;
import com.xiaowo.common.response.ResponseUtil;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Map;

/* =======================================================
 * 小窝
 * 日 期：10/3/16
 * 作 者：Hannah
 * 版 本：0.0.1
 * 描 述：TODO
 * ========================================================
 */
public class JerseyClientUtil {

    private static JerseyClientUtil.MyJerseyClient singleton = new JerseyClientUtil.MyJerseyClient();

    private JerseyClientUtil() {
    }

    public static Response httpGet(String url) {
        return singleton.httpGet(url);
    }

    public static Response httpGet(String url, MultivaluedMap<String, Object> headers) {
        return singleton.httpGet(url, headers);
    }

    public static Response httpGet(String host, int port, String resource) {
        return singleton.httpGet(getHttpUrl(host, port, resource));
    }

    public static Response httpGet(String host, int port, String resource, MultivaluedMap<String, Object> headers) {
        return singleton.httpGet(getHttpUrl(host, port, resource), headers);
    }

    public static Response httpDelete(String url) {
        return singleton.httpDelete(url);
    }

    public static Response httpDelete(String url, MultivaluedMap<String, Object> headers) {
        return singleton.httpDelete(url, headers);
    }

    public static Response httpDelete(String host, int port, String resource) {
        return singleton.httpDelete(getHttpUrl(host, port, resource));
    }

    public static Response httpDelete(String host, int port, String resource, MultivaluedMap<String, Object> headers) {
        return singleton.httpDelete(getHttpUrl(host, port, resource), headers);
    }

    public static Response httpPostForm(String url, Map<String, String> map) {
        return singleton.httpPostForm(url, map);
    }

    public static Response httpPostForm(String url, Map<String, String> map, MultivaluedMap<String, Object> headers) {
        return singleton.httpPostForm(url, map, headers);
    }

    public static Response httpPostForm(String host, int port, String resource, Map<String, String> map) {
        return singleton.httpPostForm(getHttpUrl(host, port, resource), map);
    }

    public static Response httpPostForm(String host, int port, String resource, Map<String, String> map, MultivaluedMap<String, Object> headers) {
        return singleton.httpPostForm(getHttpUrl(host, port, resource), map, headers);
    }

    public static <T> Response httpPostJson(String url, T entity) {
        return singleton.httpPostJson(url, entity);
    }

    public static <T> Response httpPostJson(String url, T entity, MultivaluedMap<String, Object> headers) {
        return singleton.httpPostJson(url, entity, headers);
    }

    public static <T> Response httpPostJson(String host, int port, String resource, T entity) {
        return singleton.httpPostJson(getHttpUrl(host, port, resource), entity);
    }

    public static <T> Response httpPostJson(String host, int port, String resource, T entity, MultivaluedMap<String, Object> headers) {
        return singleton.httpPostJson(getHttpUrl(host, port, resource), entity, headers);
    }

    public static Response httpPutForm(String url, Map<String, String> map) {
        return singleton.httpPutForm(url, map);
    }

    public static Response httpPutForm(String url, Map<String, String> map, MultivaluedMap<String, Object> headers) {
        return singleton.httpPutForm(url, map, headers);
    }

    public static Response httpPutForm(String host, int port, String resource, Map<String, String> map) {
        return singleton.httpPutForm(getHttpUrl(host, port, resource), map);
    }

    public static Response httpPutForm(String host, int port, String resource, Map<String, String> map, MultivaluedMap<String, Object> headers) {
        return singleton.httpPutForm(getHttpUrl(host, port, resource), map, headers);
    }

    public static <T> Response httpPutJson(String url, T entity) {
        return singleton.httpPutJson(url, entity);
    }

    public static <T> Response httpPutJson(String url, T entity, MultivaluedMap<String, Object> headers) {
        return singleton.httpPutJson(url, entity, headers);
    }

    public static <T> Response httpPutJson(String host, int port, String resource, T entity) {
        return singleton.httpPutJson(getHttpUrl(host, port, resource), entity);
    }

    public static <T> Response httpPutJson(String host, int port, String resource, T entity, MultivaluedMap<String, Object> headers) {
        return singleton.httpPutJson(getHttpUrl(host, port, resource), entity, headers);
    }

    private static String getHttpUrl(String host, int port, String resource) {
        return getUrl("http", host, port, resource);
    }

    private static String getUrl(String schema, String host, int port, String resource) {
        String url = schema + "://" + host + ":" + port;
        if(null == resource) {
            return url;
        } else {
            String resourcePath = resource.trim();
            return resourcePath.length() == 0?url:(resourcePath.startsWith("/")?url + resourcePath:url + "/" + resourcePath);
        }
    }

    private static class MyJerseyClient {
        private MyJerseyClient() {
        }

        Response httpGet(String url) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).get();
            response.bufferEntity();
            return response;
        }

        Response httpGet(String url, MultivaluedMap<String, Object> headers) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).headers(headers).get();
            response.bufferEntity();
            return response;
        }

        Response httpDelete(String url) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).delete();
            response.bufferEntity();
            return response;
        }

        Response httpDelete(String url, MultivaluedMap<String, Object> headers) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).headers(headers).delete();
            response.bufferEntity();
            return response;
        }

        Response httpPostForm(String url, Map<String, String> map) {
            if(null != map && map.size() != 0) {
                Form form = new Form();
                Iterator client = map.entrySet().iterator();

                while(client.hasNext()) {
                    Map.Entry response = (Map.Entry)client.next();
                    form.param((String)response.getKey(), (String)response.getValue());
                }

                Client client1 = ClientBuilder.newClient(new ClientConfig());
                Response response1 = client1.target(url).request(new String[]{"application/json"}).post(Entity.form(form));
                response1.bufferEntity();
                return response1;
            } else {
                return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR_PARAMETER_NULL.value(), "POST请求未包含任何数据！");
            }
        }

        Response httpPostForm(String url, Map<String, String> map, MultivaluedMap<String, Object> headers) {
            if(null != map && map.size() != 0) {
                Form form = new Form();
                Iterator client = map.entrySet().iterator();

                while(client.hasNext()) {
                    Map.Entry response = (Map.Entry)client.next();
                    form.param((String)response.getKey(), (String)response.getValue());
                }

                Client client1 = ClientBuilder.newClient(new ClientConfig());
                Response response1 = client1.target(url).request(new String[]{"application/json"}).headers(headers).post(Entity.form(form));
                response1.bufferEntity();
                return response1;
            } else {
                return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR_PARAMETER_NULL.value(), "POST请求未包含任何数据！");
            }
        }

        <T> Response httpPostJson(String url, T entity) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).post(Entity.json(entity));
            response.bufferEntity();
            return response;
        }

        <T> Response httpPostJson(String url, T entity, MultivaluedMap<String, Object> headers) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).headers(headers).post(Entity.json(entity));
            response.bufferEntity();
            return response;
        }

        Response httpPutForm(String url, Map<String, String> map) {
            if(null != map && map.size() != 0) {
                Form form = new Form();
                Iterator client = map.entrySet().iterator();

                while(client.hasNext()) {
                    Map.Entry response = (Map.Entry)client.next();
                    form.param((String)response.getKey(), (String)response.getValue());
                }

                Client client1 = ClientBuilder.newClient(new ClientConfig());
                Response response1 = client1.target(url).request(new String[]{"application/json"}).put(Entity.form(form));
                response1.bufferEntity();
                return response1;
            } else {
                return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR_PARAMETER_NULL.value(), "POST请求未包含任何数据！");
            }
        }

        Response httpPutForm(String url, Map<String, String> map, MultivaluedMap<String, Object> headers) {
            if(null != map && map.size() != 0) {
                Form form = new Form();
                Iterator client = map.entrySet().iterator();

                while(client.hasNext()) {
                    Map.Entry response = (Map.Entry)client.next();
                    form.param((String)response.getKey(), (String)response.getValue());
                }

                Client client1 = ClientBuilder.newClient(new ClientConfig());
                Response response1 = client1.target(url).request(new String[]{"application/json"}).headers(headers).put(Entity.form(form));
                response1.bufferEntity();
                return response1;
            } else {
                return ResponseUtil.getBizErrorResponse(ErrorCode.BIZ_ERROR_PARAMETER_NULL.value(), "POST请求未包含任何数据！");
            }
        }

        <T> Response httpPutJson(String url, T entity) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).put(Entity.json(entity));
            response.bufferEntity();
            return response;
        }

        <T> Response httpPutJson(String url, T entity, MultivaluedMap<String, Object> headers) {
            Client client = ClientBuilder.newClient(new ClientConfig());
            Response response = client.target(url).request(new String[]{"application/json"}).headers(headers).put(Entity.json(entity));
            response.bufferEntity();
            return response;
        }
    }
}
