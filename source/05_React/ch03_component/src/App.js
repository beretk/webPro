
import { Component } from 'react';
import './App.css';

class App extends Component{
  render(){
    return(
      <div>
        Hello, React!!!~
        <Subject></Subject>
      </div>
    )
  }
}
class Subject extends Component{
  render(){
    return(
      <header>
        <h1>React</h1>
        World Wide Web!
      </header>
    )
  }
}
export default App;
