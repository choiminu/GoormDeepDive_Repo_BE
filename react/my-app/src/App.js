import logo from './logo.svg';
import './App.css';
import Content from './component/Content'
import JSXPractice from './component/JSXPractice';
import Nav from './component/Nav';
import Subject from './component/Subject';

function App() {
  return (
    <div className="App">
      <JSXPractice/>
      <hr/>
      <h1>안녕하세요..</h1>
      <Subject> </Subject>
      <hr/>
      <Nav/>
      <hr/>
      <Content/>
    </div>
  );
}

export default App;
