import { apiFetch } from '../../lib/util/api'


class CodeApi{
    static getCodeHtml( texto ){
        console.log("codeapi   "+texto);
        return apiFetch("",texto);
    }
}

export default CodeApi;