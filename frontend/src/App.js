import Footer from "components/Footer";
import NavBar from "components/NavBar";
import Routes from "main/Routes";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <Routes />
      </div>
      <Footer />
    </>
  );
}

export default App;
