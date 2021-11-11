package task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebAddressParser {
    private URL address;

    public WebAddressParser(String address) {
        try {
            this.address = new URL(address);
        } catch (MalformedURLException var3) {
            this.address = null;
        }

    }

    public String getLogin() {
        if (this.isValid()) {
            String[] auth = this.address.getAuthority().split("@");
            if (auth.length >= 2) {
                String[] logAndPas = auth[0].split(":");
                if (logAndPas.length >= 2) {
                    return logAndPas[0];
                }
            }
        }

        return "";
    }

    public String getPassword() {
        if (this.isValid()) {
            String[] auth = this.address.getAuthority().split("@");
            if (auth.length >= 2) {
                String[] logAndPas = auth[0].split(":");
                if (logAndPas.length >= 2) {
                    return logAndPas[1];
                }
            }
        }

        return "";
    }

    public String getScheme() {
        return this.isValid() ? this.address.getProtocol() : "";
    }

    public boolean isValid() {
        return this.address != null;
    }

    public String getHost() {
        return this.isValid() ? this.address.getHost() : "";
    }

    public String getPort() {
        return this.isValid() && this.address.getPort() != -1 ? Integer.toString(this.address.getPort()) : "";
    }

    public String getUrl() {
        return this.isValid() ? this.address.getPath().replaceFirst("/", "") : "";
    }

    public HashMap<String, String> getParameters() {
        HashMap<String, String> parameters = new HashMap();
        if (this.isValid() && this.address.getQuery() != null) {
            String[] allPar = this.address.getQuery().split("&");

            for(int i = 0; i < allPar.length; ++i) {
                String[] eachPar = allPar[i].split("=");
                parameters.put(eachPar[0], eachPar[1]);
            }
        }

        return parameters;
    }

    public String getFragment() {
        return this.isValid() && this.address.getRef() != null ? this.address.getRef() : "";
    }
}
