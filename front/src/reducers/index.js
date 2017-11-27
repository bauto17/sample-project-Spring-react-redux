import { combineReducers } from 'redux';

import code from './codeReducer';
import htmlCode from '../components/show/reducer';

const rootReducer = combineReducers({
    htmlCode
});
export default rootReducer;