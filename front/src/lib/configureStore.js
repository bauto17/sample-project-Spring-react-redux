import isoFetch from "isomorphic-fetch";
import promiseMiddleware from 'redux-promise-middleware';
import reduxImmutableState from 'redux-immutable-state-invariant';
import {createStore, applyMiddleware} from 'redux';

const injectMiddleware = deps => ({dispatch,getState}) => next => action => 
next(typeof action === 'function'? action({...deps, dispatch, getState}) : action);

export default function configureStore(options,rootReducer){
    const { initialState = {}} = options;
    const middleware = [
        injectMiddleware({fecth : isoFetch}),
        promiseMiddleware({promiseTypeSuffixes: ['START','SUCCESS','ERROR']}),
        reduxImmutableState()
    ]; 
    return createStore(rootReducer, initialState, applyMiddleware(...middleware));
}; 