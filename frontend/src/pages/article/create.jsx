import React from 'react';

import Layout from "../../components/Layout";
import '@toast-ui/editor/dist/toastui-editor.css';
import Editor from '@toast-ui/editor';
import Writer from "../../components/Writer";

const CreateArticle = () => {

    return (
        <Layout>
            <div className="px-[1rem]">
                <Writer />
            </div>
        </Layout>
    )
}

export default CreateArticle