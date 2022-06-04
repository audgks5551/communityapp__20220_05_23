import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import "./styles/tw.output.css";
import ArticleList from "./pages/article/list";
import CreateArticle from "./pages/article/create";

function App() {

    return (
        <BrowserRouter>
            <Routes>
                <Route index element={<Home />} />
                <Route path="/article" element={<ArticleList />} />
                <Route path="/article/new" element={<CreateArticle />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
