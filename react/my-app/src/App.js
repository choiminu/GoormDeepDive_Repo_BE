import logo from './logo.svg';
import './App.css';
import Header from './component/Header';
import Sidebar from './component/Sidebar';
import FeaturedSection from './component/FeaturedSection';
import Footer from './component/Footer';

function App() {
  return (
    <div className="App">
      <Header/>
      <Sidebar/>
      <FeaturedSection/>
      <Footer/>
    </div>
  );
}

export default App;
