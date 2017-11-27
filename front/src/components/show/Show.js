import React, { Component } from 'react';
import './Show.css';
import { connect } from 'react-redux';
import Proptypes from 'prop-types';
import * as actions from './actions';

class Show extends Component {
  static propTypes = {
    loadHtmlCode : Proptypes.func.isRequired,
    code : Proptypes.string
  }
  constructor(props){
    super(props); 
  }
  render() {
    let { code }= this.props;
    console.log("render");
    console.log(code);
    console.log(this.props);
    return (
      <div className="Show">
        <h3>traduccion</h3>
        <textarea value={code} disabled className="Show-textarea">
         
        </textarea>
      </div>
    );
  }
}
export default connect( 
  state =>{
    return {code: state.htmlCode.code};
  },
  actions
)(Show);
