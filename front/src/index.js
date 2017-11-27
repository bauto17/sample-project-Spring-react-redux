import React from 'react';
import 'babel-polyfill';
import ReactDOM from 'react-dom';   
import './index.css';
import App from './components/App';
import registerServiceWorker from './registerServiceWorker';

import { Provider } from 'react-redux';

import configureStore from './lib/configureStore';
import rootReducer from './reducers';

import blueBird from 'bluebird';

window.promise = blueBird;
blueBird.config({warnings:false});

window.addEventListener('unhandledrejection', error => {
    error.preventDefault();
    console.log(error);
})
const store = configureStore({
},rootReducer);
ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>, 
    document.getElementById('root')
);
registerServiceWorker();
