const initialState={
    htmlCode: ""
};

export default function htmlCodeReducer(state= initialState,action){
    switch(action.type){
        case 'GETCODE_SUCCESS':{
            console.log("entro al getcode success");
            const {payload: {response = []}}=action;
            console.log( action.payload);
            return Object.assign({}, state, {code:action.payload.content});
        }
        default:{
            return state;
        }   
    }
}

