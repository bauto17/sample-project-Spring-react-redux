import config from "../../config"

export function apiFetch(endpoint, texto=""){
    const getPromise = async ()=>{
        try{
            console.log("entro a ");
            const fetchOptions = apiOptions(texto);
            const fetchEndpoint = config.javaService.url+"code/";
            const response = await fetch(fetchEndpoint,fetchOptions);
            return response.json();
        }catch(e){
            throw e;
        }
    }

    let otra = getPromise();
    return otra;
}

function apiOptions(texto){
    const options= {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify({content:texto})
    };
    return options;
}