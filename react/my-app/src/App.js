import logo from './logo.svg';
import './App.css';
import Header from './component/Header';
import Sidebar from './component/Sidebar';
import FeaturedSection from './component/FeaturedSection';
import Footer from './component/Footer';
import RandomNumber from './state/RandomNumber';

function App() {
  return (
    <div className="App">
      <RandomNumber/>
    </div>
  );
}

export default App;
