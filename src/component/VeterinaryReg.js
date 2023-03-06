import { useReducer } from "react";
export default function VeterinaryReg()
{
    const init={
        username:"",
        password:"",
        vetname:"",
        regno:"",
        hospitalname:"",
        qualification:"",
        phoneno:"",
        address:""
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

    var sendData=(e)=>{
        e.preventDefault();
        const reqOption={
            method:'POST',
            headers:{'content-type':'application/json'},
            body:JSON.stringify(info)

        }
        fetch('http://localhost:8080/regVeterinary',reqOption)
        .then(resp=>{console.log(resp.ok);
            if(resp.ok)
                        return resp.json();
                    else
                        throw new Error("server Error");
                    }
             )
        
    }



    return(
        <>
        <h1>Veterinary Registration</h1>
        <form>
            <div className="mb-3">
                <label htmlFor="username" className="form-label">Enter Username:</label>
                <input type="text" className="form-control" id="username" name="username" value={info.username}
                onChange={(e)=>{dispatch({type:'update',fld:'username',val:e.target.value})}}/>
                <div id="usernamehelp" className="form-text">valid username</div>
            </div>

            <div className="mb-3">
                <label htmlFor="password" className="form-label">Enter password:</label>
                <input type="text" className="form-control" id="password" name="password"value={info.password}
                onChange={(e)=>{dispatch({type:'update',fld:'password',val:e.target.value})}} />
                <div id="passwordhelp" className="form-text">....</div>
            </div>

            

            <div className="mb-3">
                <label htmlFor="vetname" className="form-label">Enter Name:</label>
                <input type="text" className="form-control" id="vetname" name="vetname"value={info.firstname}
                onChange={(e)=>{dispatch({type:'update',fld:'vetname',val:e.target.value})}} />
                <div id="vetnamehelp" className="form-text">....</div>
            </div>

            <div className="mb-3">
                <label htmlFor="regno" className="form-label">Enter Registraion no.:</label>
                <input type="text" className="form-control" id="regno" name="regno" value={info.regno}
                onChange={(e)=>{dispatch({type:'update',fld:'regno',val:e.target.value})}}/>
                <div id="regnohelp" className="form-text">valid regno</div>
            </div>
            
            <div className="mb-3">
                <label htmlFor="hospitalname" className="form-label">Enter Hospital Name:</label>
                <input type="text" className="form-control" id="hospitalname" name="hospitalname" value={info.hospitalname}
                onChange={(e)=>{dispatch({type:'update',fld:'hospitalname',val:e.target.value})}}/>
                <div id="hospitalnamehelp" className="form-text">valid hospitalname</div>
            </div>


            <div className="mb-3">
                <label htmlFor="qualification" className="form-label">Enter qualification:</label>
                <input type="text" className="form-control" id="qualification" name="qualification"value={info.qualification}
                onChange={(e)=>{dispatch({type:'update',fld:'qualification',val:e.target.value})}} />
                <div id="qualificationhelp" className="form-text">....</div>
            </div>

            

            <div className="mb-3">
                <label htmlFor="phoneno" className="form-label">Enter phoneno:</label>
                <input type="text" className="form-control" id="phoneno" name="phoneno"value={info.phoneno}
                onChange={(e)=>{dispatch({type:'update',fld:'phoneno',val:e.target.value})}} />
                <div id="phonenohelp" className="form-text">....</div>
            </div>

            <div className="mb-3">
                <label htmlFor="address" className="form-label">Enter address:</label>
                <input type="text" className="form-control" id="address" name="address"value={info.address}
                onChange={(e)=>{dispatch({type:'update',fld:'address',val:e.target.value})}} />
                <div id="addresshelp" className="form-text">....</div>
            </div>
            

            <button type="submit" className="btn btn-primary md-3" name="login" onClick={(e)=>{sendData(e)}} >submit</button>
            <button type="reset" className="btn btn-primary md-3" name="login" onClick={()=>dispatch({type:'reset'})}>reset</button>
            
        </form>
        <p>{JSON.stringify(info)}</p>
        {/* <p>{msg}</p> */}
        
        
        
        
        
        
        </>
    )
    
    }