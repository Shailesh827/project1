import { useReducer, useState, useEffect } from "react"
import { useNavigate } from "react-router-dom";

import { useDispatch } from "react-redux";
import { login } from "./slice";
import Admin from "./AdminHome";
import { Link, Route ,Routes} from 'react-router-dom';
export default function ShelterComp()
{
   const navigate=useNavigate();
   const reduxAction = useDispatch();
    
   const[allshelter,setAllShelter]=useState([]);
   
   useEffect(()=>{
    fetch("http://localhost:8080/getShelter")
    .then(resp=>resp.json())
    .then(obj=>setAllShelter(obj))


   },[]);

 return(
    <div>
       <table className = "table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th> Shelter Name</th>
                        <th> Address</th>
                        <th> Phone no.</th>
                    </tr>

                </thead>
                <tbody>
                    {
                        allshelter.map(
                                shelter =>
                                <tr key = {shelter.shelterid}>
                                    <td> {shelter.shelterid }</td>
                                    <td> {shelter.sheltername }</td>
                                    <td> {shelter.address }</td>    
                                    <td> {shelter.phoneno }</td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
    </div>

   )
  
}