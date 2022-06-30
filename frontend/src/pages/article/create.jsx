import React from 'react';

import Layout from "../../components/Layout";
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