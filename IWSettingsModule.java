/*   
   Icewolf -- a lightweight web-browser
   Copyright 2017

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

import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class IWSettingsModule {

    private Stage stage;
    private TextField urlTextField;
    private TextField searchTextField;
    private WebView webView;
    
    public IWSettingsModule(Stage stage, TextField urlTextField, TextField searchTextField, WebView webView) {
        this.stage = stage;
        this.urlTextField = urlTextField;
        this.searchTextField = searchTextField;
        this.webView = webView;
        
        System.out.println("Module SettingsModule has been triggered!");
    }
}
