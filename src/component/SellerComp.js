import { Link,Route,Routes } from "react-router-dom";
import LoginComp from "./LoginComp";

export default function SellerComp()
{
    return(<div>

           <nav className="navbar navbar-expand-sm  bg-light mb-3">
                  <div className='container-fluid'>
                    <ul className="navbar-nav">
                     
                      <li className='nav-item'>
                        <Link to="login" className='nav-link px-3'>View </Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="/addpet" className='nav-link px-3'>add pet </Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="/logout" className='nav-link px-3'>Logout</Link>
                      </li>
                    </ul>
            </div>
          </nav>
        <h1>Seller Home</h1>
        <div>
            <Routes>
            <Route path="/login" element={<LoginComp/>}>
            </Route>
            </Routes>        
        </div>
    </div>)
}