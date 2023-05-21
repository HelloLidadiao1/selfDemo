package ${packageName};

public class ${className} {
<#list fieldList as field>
    private ${field.javaType} ${field.name};
</#list>
<#list fieldList as field>
    public ${field.javaType} get${field.upperName}() {
        return ${field.name};
    }

    public void set${field.upperName}(${field.javaType} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}
