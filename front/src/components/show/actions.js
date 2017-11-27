import codeApi from './api';

const SENTCODE = 'SETCODE';
const GETCODE = 'GETCODE';

export function loadHtmlCode( text ){
    return {
        type: GETCODE,
        payload: codeApi.getCodeHtml(text)
    }
}
