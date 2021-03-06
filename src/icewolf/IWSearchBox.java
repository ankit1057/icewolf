/*   
   Icewolf -- a lightweight web-browser
   Copyright 2017 Nick Ivanov, Gregory Bowen, Dylan Parsons
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package icewolf;

import java.util.HashMap;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
/**
 *
 * @author gbowen
 */
public class IWSearchBox extends TextField {

    private final WebView webView;
    private int searchProvider;
    private String[] providerArray = {
        "http://www.google.com/search?q=", //Google
        "http://search.yahoo.com/search;_ylt=A0oG7l7PeB5P3G0AKASl87UF?p=",//Yahoo
        "http://www.bing.com/search?q=", //Bing
        "http://duckduckgo.com/html?q=", //DuckDuckGo
        "http://archive.org/search.php?query=", //Internet Archive
        "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords="
        //More search engine URL's can be added later
    };
    
    
    private final HashMap<String, String> searchUrls = new HashMap();
    
    public IWSearchBox(WebView webView, int searchProvider) {
        this.webView = webView;
        this.searchProvider = searchProvider;        
        
        searchUrls.put("Google", providerArray[0]);
        searchUrls.put("Yahoo", providerArray[1]);
        searchUrls.put("Bing", providerArray[2]);
        searchUrls.put("DuckDuckGo", providerArray[3]);
        searchUrls.put("Internet Archive", providerArray[4]);
        searchUrls.put("Amazon", providerArray[5]);
    }
    
    public void changeSearchProvider(int newProvider){
        this.searchProvider = newProvider;
    }
    
    public void search(){
        IWSettingsController controller = new IWSettingsController();        
        String engine = controller.getSearchEngine();

        //String rawSearch = providerArray[searchProvider] + this.getText().toString();
        String rawSearch = searchUrls.get(engine) + this.getText().toString();
        webView.getEngine().load(rawSearch.replaceAll("\\s","+"));
    }
}