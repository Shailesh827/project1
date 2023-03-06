import {Link, Navigate, Route, Routes } from "react-router-dom";
import { useReducer } from "react";
import SellerComp from "./SellerComp";
import { useState,useEffect } from "react";
export default function AddPetComp()
{
    const [seller,setSeller]=useState(null);
    useEffect(()=>{
        const login_id=JSON.parse(localStorage.getItem("logginedUser")).loginid;

        

        fetch("http://localhost:8080/getSeller?loginid="+login_id)
        .then(resp=>{
            console.log("loginid ="+login_id);
            if(resp.ok)
                return resp.json();
            else
                throw new Error("server Error");
            
    },[])
    .then(obj=>{
        console.log("Sellerid ="+obj.sellerid);
        localStorage.setItem("loggedSeller",JSON.stringify(obj));
        
     })
     
})





    const init={
        
        petname:"",
        breed:"",
        color:"",
        gender:"",
        age:'',
        price:'',
        type:"",
       sellerid:JSON.parse(localStorage.getItem("loggedSeller")).sellerid
    }

    const reducer=(state,action)=>{
        switch(action.type)
        {
            case 'update':
                return {...state,[action.fld]:action.val}
            case 'reset':
                return init;
        }
    }

    
    const [info,dispatch]=useReducer(reducer,init);
    const [file,setFile]=useState();
    var sendData=(e)=>{
        e.preventDefault();
        const reqOption={
            method:'POST',
            headers:{'content-type':'application/json'},
            body:JSON.stringify(info)

        }
        fetch('http://localhost:8080/regPet',reqOption)
        .then(resp=>{if(resp.ok)
                        return resp.json();
                    else
                        throw new Error("server Error");
        })
        // .then(obj=>{
        //     const fd=new FormData();
            
        //     const reqOption1={
        //         method:'POST',
        //         header:{'content-type':'multipart/from-data'},
        //         body:fd
        //     }
        //     fetch("http://localhost:8080/uploadImage/"+obj.petid,reqOption1)
        //     .then(resp=>resp.json())
        //     .then(obj1=>{
        //             if(obj1)
        //             {
        //                 alert("Pet registerd.");
        //                 Navigate("/");
        //             }
        //             else
        //             {
        //                 alert("Pet registerd but pet image upload failed.Try again");
        //             }
        //     })
            
        // })
        // .catch((error)=>{
        //     alert("server error");
        // })

             
        
    }
  

    return(
        <>
           <nav className="navbar navbar-expand-sm  bg-light mb-3">
                  <div className='container-fluid'>
                    <ul className="navbar-nav">
                      <li className='nav-item'>
                        <Link to="/viewpet" className='nav-link px-3'>view Pet</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="/addpet" className='nav-link px-3'>Add Pet</Link>
                      </li>
                      <li className='nav-item'>
                        <Link to="/logout" className='nav-link px-3'>Logout</Link>
                      </li>
                    </ul>
                </div>
            </nav>
        <h1>Enter Pet Details</h1>
        
        <form>
        <div className="mb-3">
                <label htmlFor="petname" className="form-label">Enter petname:</label>
                <input type="text" className="form-control" id="petname" name="petname" value={info.petname}
                onChange={(e)=>{dispatch({type:'update',fld:'petname',val:e.target.value})}}/>
                <div id="petnamehelp" className="form-text">valid petname</div>
            </div>
            
            <div className="mb-3">
                <label htmlFor="breed" className="form-label">Enter breed:</label>
                <input type="text" className="form-control" id="breed" name="breed"value={info.breed}
                onChange={(e)=>{dispatch({type:'update',fld:'breed',val:e.target.value})}} />
                <div id="breedhelp" className="form-text">....</div>
            </div>

            

            <div className="mb-3">
                <label htmlFor="color" className="form-label">Enter color:</label>
                <input type="text" className="form-control" id="color" name="color" value={info.color}
                onChange={(e)=>{dispatch({type:'update',fld:'color',val:e.target.value})}} />
                <div id="colorhelp" className="form-text">....</div>
            </div>

                            
             <div class="btn-group btn-group-toggle" data-toggle="buttons">
                Enter gender:
                <label class="btn btn-secondary active">
                    <input type="radio" name="gender" id="Male" 
                    onChange={(e)=>{dispatch({type:'update',fld:'gender',val:e.target.value})}}/> Male
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="gender" id="Female" 
                    onChange={(e)=>{dispatch({type:'update',fld:'gender',val:e.target.value})}} /> Female
                </label>
            </div> 
            
            <div className="mb-3">
                <label htmlFor="price" className="form-label">Enter price:</label>
                <input type="text" className="form-control" id="price" name="price"value={info.price}
                onChange={(e)=>{dispatch({type:'update',fld:'price',val:e.target.value})}} />
                <div id="pricehelp" className="form-text">....</div>
            </div>

            <div className="mb-3">
                <label htmlFor="age" className="form-label">Enter age:</label>
                <input type="text" className="form-control" id="age" name="age"value={info.age}
                onChange={(e)=>{dispatch({type:'update',fld:'age',val:e.target.value})}} />
                <div id="agehelp" className="form-text">....</div>
            </div>
            

            {/* <div className="mb-3">
                <label htmlFor="status" className="form-label">Enter status:</label>
                <input type="text" className="form-control" id="status" name="status"value={info.status}
                onChange={(e)=>{dispatch({type:'update',fld:'status',val:e.target.value})}} />
                <div id="statushelp" className="form-text">....</div>
            </div> */}

            <div className="mb-3">
                <label htmlFor="type" className="form-label">Enter Pet type:</label>
                <input type="text" className="form-control" id="type" name="type" value={info.type}
                onChange={(e)=>{dispatch({type:'update',fld:'type',val:e.target.value})}}/>
                <div id="typehelp" className="form-text">...</div>
            </div>
            
            <div className="mb-3">
                <label htmlFor="type" className="form-label">Upload File:</label>
                <input type="file" className="form-control" id="image" name="image" 
                onChange={(e)=>{setFile(e.target.files[0])}}/>
            </div>
        
            <button type="submit" className="btn btn-primary md-3" name="login" onClick={(e)=>{sendData(e)}} >submit</button>
            <button type="reset" className="btn btn-primary md-3" name="login" onClick={()=>dispatch({type:'reset'})}>reset</button>
            
        </form>
        <p>{JSON.stringify(info)}</p>
        <p>{file && file.name}</p>
        <p></p>
              
        </>
    )
}