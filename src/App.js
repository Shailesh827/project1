import logo from './logo.svg';
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import LoginComp from './component/LoginComp';
import AdminHome from './component/AdminHome';
import SellerComp from './component/SellerComp';
import BuyerComp from './component/BuyerComp';
import VeterinaryComp from './component/VeterinaryComp';
import TrainerComp from './component/TrainerComp';
import Logout from './component/Logout';
import { useSelector } from 'react-redux';
import SellerReg from './component/SellerReg';
import BuyerReg from './component/BuyerReg';
import TrainerReg from './component/TrainerReg';
import VeterinaryReg from './component/VeterinaryReg';
import ShelterComp from './component/ShelterComp';
import AddPetComp from './component/AddPetComp';

function App() {
  const mystate=useSelector((state)=>state.logged);
  return (
    <div className="App">
      <div style={{display:mystate.loggedIn ? "none":"block"}}>
          <nav className="navbar navbar-expand-sm  bg-light mb-3">
                  <div className='container-fluid'>
                    <ul className="navbar-nav">
                      <li className='nav-item'>
                        <Link to="/" className='nav-link px-3'>Home</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="login" className='nav-link px-3'>Login</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="seller_register" className='nav-link px-3'>Seller register</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="/buyer_register" className='nav-link px-3'>Buyer register</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="veterinary_register" className='nav-link px-3'>Veterinary register</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="trainer_register" className='nav-link px-3'>Trainer register</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="shelter" className='nav-link px-3'>Shelter</Link>
                      </li>

                    </ul>

            </div>
          </nav>
          <h1 className='bg-primary text-white'>Happy Pet</h1>
      </div>


     <Routes>
      <Route path='/login' element={<LoginComp/>}></Route>
      <Route path='/admin_home' element={<AdminHome/>}></Route>
      <Route path='/seller_home' element={<SellerComp/>}></Route>
      <Route path='/buyer_home' element={<BuyerComp/>}></Route>
      <Route path='/veterinary_home' element={<VeterinaryComp/>}></Route>
      <Route path='/trainer_home' element={<TrainerComp/>}></Route> 
      <Route path='/logout' element={<Logout/>}></Route> 
      <Route path='/seller_register' element={<SellerReg/>}></Route>
      <Route path='/buyer_register' element={<BuyerReg/>}></Route>
      <Route path='/trainer_register' element={<TrainerReg/>}></Route>
      <Route path='/veterinary_register' element={<VeterinaryReg/>}></Route>
      <Route path='/shelter' element={<ShelterComp/>}></Route>
      <Route path='/addpet' element={<AddPetComp/>}></Route>
     </Routes>
    </div>
  );
}

export default App;








