import { Component } from 'react';
import './Subject.css';
class Subject extends Component{
    render(){
        console.log('Subject render수행');
      return(
        <header>
            <h1>
                <a href="/" onClick={function(e){
                        e.preventDefault(); // a태그의 기본동작 막음
                        this.props.onChangePage();
                        }.bind(this)}>
                    {this.props.title}
                </a>
                </h1>
            {this.props.sub} 
        </header>
      );
    }
  }
  export default Subject;