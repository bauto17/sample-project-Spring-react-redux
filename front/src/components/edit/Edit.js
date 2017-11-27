import React, { Component } from 'react';
import './Edit.css';
import { connect } from 'react-redux';
import Proptypes from 'prop-types';
import * as actions from '../show/actions';

class Edit extends Component {
  static propTypes = {
    loadHtmlCode : Proptypes.func.isRequired
  }
  constructor(props){
    super(props); 
    this.enviar = this.enviar.bind(this);
  }
  enviar(){
    this.props.loadHtmlCode(this.refs.input.value);
  }
  render() {
    return (
      <div className="Edit">
        <h3>editor</h3>
        <textarea className="Edit-textarea" ref='input'>
          texto base
        </textarea>
        <div className="Edit-cb">
          <button className="Edit-button" onClick={this.enviar} >
            enviar
          </button>
          <button className="Edit-button">
            borrar
          </button>
        </div>
      </div>
    );
  }
}
export default connect( 
  state =>{
    return {code: state.htmlCode.code};
  },
  actions
)(Edit);