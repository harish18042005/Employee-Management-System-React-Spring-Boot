import Employee from "./components/Employee"
import Footer from "./components/Footer"
import Header from "./components/Header"
import HomeComponent from "./components/HomeComponent"
import ListEmployeeComponenet from "./components/ListEmployeeComponenet"
import {BrowserRouter, Routes, Route} from 'react-router-dom'


function App() {

  return (
    <>
      <BrowserRouter>
        <Header/>
          <Routes>
            <Route path="/" element={<HomeComponent/>}></Route>
            <Route path="/employees"  element={<ListEmployeeComponenet/>}></Route>
            <Route path="/add-employee" element={<Employee/>}></Route>
            <Route path="/edit-employee/:id" element={<Employee/>}/>
          </Routes>
        <Footer/>
      </BrowserRouter>
    </>
    
  )
}

export default App
