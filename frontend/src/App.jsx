import {BrowserRouter, Routes, Route} from "react-router-dom";
import Welcome from "./components/Welcome";

function App() {

    return (
        <BrowserRouter>
            <Routes>
                <Route index element={<Welcome/>} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
